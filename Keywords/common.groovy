import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class common {
	
	public static JsonSlurper jsonSlurper = new JsonSlurper()
	
		@Keyword
		def String CheckOrganizationPositif(String org_name) {
			def response = WS.sendRequestAndVerify(findTestObject('Object Repository/API/CheckOrganizationPositif', [("org_name"): org_name]))
	
			def jsonResponse = jsonSlurper.parseText(response.getResponseText())
			return jsonResponse.name
		}
	
		@Keyword
		def static void LoginPositif(String org_name, String username, String password) {
			WS.sendRequestAndVerify(findTestObject('Object Repository/API/LoginPositif',["org_name": org_name, "username": username, "password": password]))
		}
}
