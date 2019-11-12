package objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Use Page Object Factory
public class SearchRepository {
	WebDriver webDriver;
	private final String MAIN_CART_BUTTON = "div[id='cart'] button a";
	private final String MINI_CART_BUTTON = "div[class='mini-cart-total'] p a";
	@FindBy(css="input[name='search']")
	private WebElement searchInput;
	@FindBy(xpath="//h4[@class='name']/a")
	private List<WebElement> searchedItemElements;
	@FindBy(id="button-cart")
	private WebElement addToCartButtonElement;
	private By mainAddToCartButton = By.cssSelector(MAIN_CART_BUTTON);
	private By miniCartButton = By.cssSelector(MINI_CART_BUTTON);
	@FindBy(css=MAIN_CART_BUTTON)
	private WebElement mainCartButtonElement;
	@FindBy(css=MINI_CART_BUTTON)
	private WebElement miniCartButtonElement;
	@FindBy(tagName="iframe")
	private List<WebElement> iframes;
	@FindBy(xpath="(//table/tbody/tr/td[@class='text-left name']/a)[2]")
	private WebElement itemNamElement;
	
	public SearchRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getSearchInputElement() { return searchInput; }
	public List<WebElement> getSearchedItemElements() { return searchedItemElements; }
	public WebElement getAddToCartButtonElement() { return addToCartButtonElement; }
	public By getMainCartButtonBy() { return mainAddToCartButton; }
	public By getMiniCartButtonBy() { return miniCartButton; }
	public WebElement getMainCartButtonElement() { return mainCartButtonElement; }
	public WebElement getMiniCartButtonElement() { return miniCartButtonElement; }
	public List<WebElement> getIframesElements() { return iframes; }
	public WebElement getDisplayedItemName() { return itemNamElement; }
}
