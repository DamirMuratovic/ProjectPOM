package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VideoTutorialsPage extends BaseTest {
    public VideoTutorialsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "yt-tab-shape-wiz__tab")
    public List<WebElement> youTubeTabs;

    @FindBy(id = "video-title")
    public List<WebElement> videoLinks;

    @FindBy(id = "subscribe-button-shape")
    public WebElement subscribeButton;

    @FindBy(id = "ad-text:6")
    public WebElement skipButton;


    //-------------------------------------------------

    public void clickOnYtTab(String tab){
        for (WebElement tabs: youTubeTabs){
            if(tabs.getText().equalsIgnoreCase(tab)){
                tabs.click();
                break;
            }
        }
    }

    public void clickOnRandomVideo(){
        int video = r.nextInt(videoLinks.size());
        //System.out.println(videoLinks.get(video).getText());
        videoLinks.get(video).click();
    }

    public void clickOnSkipButton(){
        skipButton.click();
    }
}