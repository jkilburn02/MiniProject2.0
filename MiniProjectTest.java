import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniProjectTest {

    //4 tests that should return true (all tests passed)
    @Test
    void validSentence1(){
        assertTrue(MiniProject.tests("The quick brown fox said hello Mr lazy dog."));
    }

    @Test
    void validSentence2(){
        assertTrue(MiniProject.tests("How many \"lazy dogs\" are there?"));
    }

    @Test
    void validSentence3(){
        assertTrue(MiniProject.tests("The quick brown fox said \"hello Mr lazy dog how are your 13 pups\"."));
    }

    @Test
    void validSentence4(){
        assertTrue(MiniProject.tests("The quick brown fox said \"hello Mr lazy dog how are your three pups\"."));
    }


    //5 Tests that should return false (at least one test failed)
    @Test
    void noCapitalLetterInvalid(){
        assertFalse(MiniProject.tests("the quick brown fox said hello Mr lazy dog."));
    }

    @Test
    void noTerminationCharacterInvalid(){
        assertFalse(MiniProject.tests("There is no punctuation in this sentence"));
    }

    @Test
    void misplacedPunctuationInvalid(){
        assertFalse(MiniProject.tests("The quick brown fox said \"hello Mr. lazy dog\"."));
    }

    @Test
    void unevenQuotationInvalid(){
        assertFalse(MiniProject.tests("\"The quick brown fox said \"hello Mr lazy dog\"."));
    }

    @Test
    void numericBelow13Invalid(){
        assertFalse(MiniProject.tests("One lazy dog is to few, 12 is too many."));
    }

}