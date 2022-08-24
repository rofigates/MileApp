import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ============================ Variable =================================

def verifyLogin

// ============================ Script ===================================

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.Base_url_web)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Web/txt_organization'), organizationName,FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Web/click'))

WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/Web/txt_usernameOrEmail'), email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('Object Repository/Web/txt_password'), password)

WebUI.click(findTestObject('Object Repository/Web/btn_login'))

verifyLogin = WebUI.verifyElementPresent(findTestObject('Object Repository/Web/lbl_passwordEmpty'), 3, FailureHandling.OPTIONAL)

if(verifyLogin) {
	WebUI.comment('Login Failed')
}else {
	WebUI.comment('Login Success')
}

WebUI.takeFullPageScreenshot()