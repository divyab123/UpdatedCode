package ProductTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Locators.ProductPage;

public class ProductTest {
	ProductPage objPrdPage = new ProductPage();
	SoftAssert asserts = new SoftAssert();
	@Test
	public void goToICIXPrd() throws Exception
	{
		objPrdPage.openPrdPage();
		String ActualHeading = objPrdPage.getTitle();
		asserts.assertEquals(ActualHeading, "Recently Viewed | ICIX Product");
	}
	
	@Test
	public void searchForTP() throws Exception
	{
		objPrdPage.clickNewBtn();
		objPrdPage.searchTPandClick();
		/*boolean actualvalue = objPrdPage.enableSearchBtn();
		asserts.assertEquals(actualvalue, true);*/
	}
	
	/*@Test
	public void SelectTP()
	{
		objPrdPage.selectTPName();
	}*/
}
