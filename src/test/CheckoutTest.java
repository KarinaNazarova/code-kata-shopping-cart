import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThrows;

public class CheckoutTest{
    //Tests whether the input with no offers will return a correct result.
    @Test
    public void testInputValidCartWithNoOffersThatReturnsTheCorrectTotalPrice() throws Exception {
        Assert.assertEquals(130, Checkout.checkout("AAB"));
    }

    //Tests whether the input with 1 offer will return a correct result.
    @Test
    public void testInputValidCartWithOneSetOfOffersThatReturnsTheCorrectTotalPrice() throws Exception {
        Assert.assertEquals(37, Checkout.checkout("BB"));
    }

    //Tests whether the input with the combination of offers will return a correct result.
    @Test
    public void testInputValidCartWithMultipleSetsOfOffersThatReturnsTheCorrectTotalPrice() throws Exception {
        Assert.assertEquals(167, Checkout.checkout("BAAAB"));
    }

    //Tests whether the input with some offers and no offers will return a correct result.
    @Test
    public void testInputValidCartWithSomeAndNoneOffersThatReturnsTheCorrectTotalPrice() throws Exception {
        Assert.assertEquals(150, Checkout.checkout("AAAC"));
    }

    //Tests whether the lowercase input correctly yields an exception.
    @Test
    public void testInvalidInputWithLowercaseCharsThatThrowsTheException() throws Exception {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Checkout.checkout("aab"));
        Assert.assertEquals("The input must be in capital letters.", exception.getMessage());
    }

    //Tests whether the input with the item that doesn't exist in the supermarket correctly yields an exception.
    @Test
    public void testInvalidInputWithItemThatDoesntExistThatThrowsTheException() throws Exception {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Checkout.checkout("AZBC"));
        Assert.assertEquals("The item Z does not exist in the supermarket.", exception.getMessage());
    }

    //Tests whether the input that contains whitespaces correctly yields an exception.
    @Test
    public void testInvalidInputWithWhitespacesThatThrowsTheException() throws Exception {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Checkout.checkout("AA DC"));
        Assert.assertEquals("Whitespaces are not allowed in the input.", exception.getMessage());
    }
}
