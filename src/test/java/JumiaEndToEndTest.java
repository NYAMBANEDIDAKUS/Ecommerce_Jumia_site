import Handlers.mainHandler;
import org.testng.annotations.Test;
import pageObjects.*;


public class JumiaEndToEndTest extends mainHandler {

  //  @Test(priority = 1)
    public void testIfCustomerIsAbleToCloseSubscriptionAlert() {

        IndexPage.closeSubscriptionAlert();
    }

   // @Test(priority=2)
    public void testSearchProduct() {
      IndexPage.searchProduct("Hp Desktop computer");
    }

   // @Test(priority = 3)
    public void testIfAllLinksAreAvailableUnderCategories(){
        IndexPage.categoriesSidePane();
    }

   // @Test(priority = 0)
    public  void testIfShouldBeAbleToSeeProductOfProductPage(){
        /*IndexPage.searchProduct("Hp Desktop computer");*/
        ProductDetailsPage.productAvailableOnProductPage("Hp Desktop computer");
    }

    @Test(priority = 0)
    public void testAddProductToPage(){

        ProductDetailsPage.addProductToCart("Hp Desktop computer");
        CartPage.checkOutItems();
        AccountPage.login();
        AddressDetailsPage.fillAddressDetails("Tester", "Tester", "712345678","406 Testing", "Nairobi", "Karen" );
        ShippingPage.selectDeliveryMethod("office");
    }

    //@Test(priority = 1)
    public void increaseQuantityOfItemInCartTest(){

    }
}
