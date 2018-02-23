package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;

public class F_ACIPage {

    WebDriver driver;
    // 1. Logos validation
    @FindBy(xpath = "//img[@class='qpp-logo']")
    WebElement qpplogo;
    @FindBy(xpath = "//img[@alt='Center for Medicaid & Medicare Services']")
    WebElement cmslogo;
    // 2. Header Elements
    @FindBy(css = "li.dropdown:nth-child(4)")
    WebElement myaccount;
    @FindBy(css = ".logout")
    WebElement logout;
    @FindBy(css = ".primary-action")
    WebElement confirm;
    // 3. Text "Advancing Care Information"
    @FindBy(css = ".page-title")
    WebElement acitxt;
    // 4. Left hand navigation bar elements
    @FindBy(linkText = "Account Dashboard")
    WebElement accountDashboard;
    @FindBy(linkText = "Connected Clinicians")
    WebElement connectedClinicians;
    @FindBy(linkText = "Group Dashboard")
    WebElement groupDashboard;
    @FindBy(linkText = "Quality Measures")
    WebElement qualityNavigation;
    @FindBy(linkText = "Advancing Care Information")
    WebElement aciNavigation;
    @FindBy(linkText = "Improvement Activities")
    WebElement iaNavigation;
    @FindBy(css = "button.link-inline")
    WebElement groupReportDD;
    @FindBy(css = ".link-collapse")
    WebElement collapsebtn;
    // 5. Toolbar Buttons
    // a) Full Instructions
    @FindBy(css = ".show-modal-btn")
    WebElement openFullInstructions;
    @FindBy(xpath = "//div[@class='modal-header']/h4")
    WebElement titleFullInstructions;
    @FindBy(css = "button.pull-right:nth-child(1)")
    WebElement closeFullInstructions;
    // b) File Upload
    @FindBy(css = ".file-upload-button")
    WebElement openFileUpload;
    @FindBy(xpath = "//button[@class='btn btn-default close-modal-btn']")
    WebElement closeFileUpload;
    @FindBy(css = ".dropzone")
    WebElement dragDropTxt;
    // c) Delete Category Data
    @FindBy(css = ".delete-measurement-set-button > button:nth-child(1)")
    WebElement deleteData;
    @FindBy(css = "button.btn-danger:nth-child(1)")
    WebElement confirmDelete;
    // 6. Performance Period window
    @FindBy(css = ".performance-start")
    WebElement startDate;
    @FindBy(css = ".performance-end")
    WebElement endDate;
    @FindBy(css = "#perf-btn")
    WebElement perfPopup;
    // 7. Hide/Show Button
    @FindBy(css = ".fa-angle-up")
    WebElement hide;
    @FindBy(css = ".fa-angle-down")
    WebElement show;
    // 9. ACI Track selection buttons
    @FindBy(css = "#transition-set")
    WebElement transitionACI;

    // 8. Electronic Health Records Lookup
    @FindBy(css = "#regular-set")
    WebElement regularACI;
    @FindBy(css = "#combo-set")
    WebElement comboACI;

    // 10. Radio Buttons in the Attestation Statement
    @FindBy(css = "button.ACI_INFBLO_1:nth-child(1)")
    WebElement ACI_INFBLO_1_Yes;
    @FindBy(css = "button.ACI_INFBLO_1:nth-child(2)")
    WebElement ACI_INFBLO_1_No;
    @FindBy(css = "button.ACI_ONCDIR_1:nth-child(1)")
    WebElement ACI_ONCDIR_1_Yes;
    @FindBy(css = "button.ACI_ONCDIR_1:nth-child(2)")
    WebElement ACI_ONCDIR_1_No;
    @FindBy(css = "button.ACI_ONCACB_1:nth-child(1)")
    WebElement ACI_ONCACB_1_Yes;
    @FindBy(css = "button.ACI_ONCACB_1:nth-child(2)")
    WebElement ACI_ONCACB_1_No;

    // 11. Advancing Care Information Category Score
    @FindBy(css = ".score")
    WebElement ACIScore;

    // 12. ACI Measurement Set - "2017 Transition ACI Score"
    // a) Required for Base Score
    @FindBy(css = "div.ACI_TRANS_EP_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_EP_1;
    @FindBy(css = "div.ACI_TRANS_EP_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_EP_1;
    @FindBy(css = "button.ACI_TRANS_PPHI_1:nth-child(1)")
    WebElement YesACI_TRANS_PPHI_1;
    @FindBy(css = "div.ACI_TRANS_PEA_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_PEA_1;
    @FindBy(css = "div.ACI_TRANS_PEA_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_PEA_1;
    @FindBy(css = "div.ACI_TRANS_HIE_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_HIE_1;
    @FindBy(css = "div.ACI_TRANS_HIE_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_HIE_1;
    // b) Optional Performance Score
    @FindBy(css = "button.ACI_TRANS_PHCDRR_1:nth-child(1)")
    WebElement YesACI_TRANS_PHCDRR_1;
    @FindBy(css = "div.ACI_TRANS_PSE_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_PSE_1;
    @FindBy(css = "div.ACI_TRANS_PSE_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_PSE_1;
    @FindBy(css = "div.ACI_TRANS_SM_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_SM_1;
    @FindBy(css = "div.ACI_TRANS_SM_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_SM_1;
    @FindBy(css = "div.ACI_TRANS_PEA_2 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_PEA_2;
    @FindBy(css = "div.ACI_TRANS_PEA_2 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_PEA_2;
    @FindBy(css = "div.ACI_TRANS_MR_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement NumACI_TRANS_MR_1;
    @FindBy(css = "div.ACI_TRANS_MR_1 > div:nth-child(2) > app-proportion-measure:nth-child(1) > form:nth-child(1) > div:nth-child(4) > input:nth-child(1)")
    WebElement DenACI_TRANS_MR_1;
    // c) Additional Registry Bonus
    @FindBy(css = "button.ACI_TRANS_PHCDRR_2:nth-child(1)")
    WebElement YesACI_TRANS_PHCDRR_2;
    @FindBy(css = "button.ACI_TRANS_PHCDRR_3:nth-child(1)")
    WebElement YesACI_TRANS_PHCDRR_3;
    // d) CEHRT Used
    @FindBy(css = "button.ACI_IACEHRT_1:nth-child(1)")
    WebElement YesACI_IACEHRT_1;
    @FindBy(xpath = "//*[@id=\"ariaJumpToLink\"]/app-aci/div[2]/section[5]/app-aci-measures/section/div/app-aci-cehrt-measures/div[2]/div/div/div[2]/div/button")
    WebElement ContinueCEHRTPopup;

    // 13. Category Score Success
    @FindBy(css = ".score-info > div:nth-child(2)")
    WebElement categorySuccess;
    // 14. Green Toaster popup
    @FindBy(css = "#toasty > ng2-toast:nth-child(1)")
    WebElement greenToaster;
    // 15. Exclusion Checkbox
    // a) "Transition ACI Measures"
    @FindBy(css = "label.ACI_TRANS_LVPP_1")
    WebElement checkACI_TRANS_LVPP_1;
    @FindBy(css = "abel.ACI_TRANS_LVOTC_1")
    WebElement checkACI_TRANS_LVOTC_1;
    // b) "Regular ACI Measures"
    @FindBy(css = "label.ACI_LVPP_1")
    WebElement checkACI_LVPP_1;
    @FindBy(css = "label.ACI_LVOTC_1")
    WebElement checkACI_LVOTC_1;
    @FindBy(css = "label.ACI_LVITC_1")
    WebElement checkACI_LVITC_1;
    // 16. ACI Help icon
    @FindBy(css = "#aci-pre-attest-btn > i:nth-child(1)")
    WebElement preattestPopup;
    @FindBy(css = ".popover-content")
    WebElement preattestPopupTxt;

    @FindBy(css = "#aci-base-popover-btn > i:nth-child(1)")
    WebElement basePopup;
    @FindBy(css = ".popover-content > span:nth-child(1)")
    WebElement basePopupTxt;

    @FindBy(css = "#aci-popover-btn > i:nth-child(1)")
    WebElement optionalPopup;

    @FindBy(css = "#aci-bonus-popover-btn > i:nth-child(1)")
    WebElement bonusPopup;

    @FindBy(css = "#aci-cehrt-popover-btn > i:nth-child(1)")
    WebElement aciCEHRTPopup;

    // 17. Performance Score
    // a) "Transition ACI Measures"
    @FindBy(css = ".row-ACI_TRANS_EP_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_EP_1;
    @FindBy(css = ".row-ACI_TRANS_PPHI_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_PPHI_1;
    @FindBy(css = ".row-ACI_TRANS_PEA_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_PEA_1;
    @FindBy(css = ".row-ACI_TRANS_HIE_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_HIE_1;
    @FindBy(css = ".row-ACI_TRANS_PHCDRR_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_PHCDRR_1;
    @FindBy(css = ".row-ACI_TRANS_PSE_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_PSE_1;
    @FindBy(css = ".row-ACI_TRANS_SM_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_SM_1;
    @FindBy(css = ".row-ACI_TRANS_PEA_2 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_PEA_2;
    @FindBy(css = ".row-ACI_TRANS_MR_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement performanceACI_TRANS_MR_1;
    // 18. Bonus Score
    // a) "Transition ACI Measures"
    @FindBy(css = ".row-ACI_TRANS_PHCDRR_2 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement bonusACI_TRANS_PHCDRR_2;

    // b) "Regular ACI Measures"
    @FindBy(css = ".row-ACI_TRANS_PHCDRR_3 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement bonusACI_TRANS_PHCDRR_3;
    @FindBy(css = ".row-ACI_IACEHRT_1 > div:nth-child(3) > div:nth-child(1) > span:nth-child(2)")
    WebElement bonusACI_IACEHRT_1;
    // 19. ACI Yellow Banners
    @FindBy(css = "div.alert:nth-child(3)")
    WebElement perfYellow;

    // b) "Regular ACI Measures"
    @FindBy(css = "app-aci-base-measures.subcategory > app-sticky:nth-child(1) > div:nth-child(2)")
    WebElement baseYellow;
    @FindBy(css = "app-aci-non-base-measures.subcategory > app-sticky:nth-child(1) > div:nth-child(2)")
    WebElement optionalYellow;
    @FindBy(css = "app-aci-bonus-measures.subcategory > app-sticky:nth-child(1) > div:nth-child(2)")
    WebElement bonusYellow;
    @FindBy(css = "app-aci-cehrt-measures.subcategory > app-sticky:nth-child(1) > div:nth-child(2)")
    WebElement CEHRTYellow;
    // 20. ACI CEHRT "Improvement Activities" anchor text
    @FindBy(css = "#ia-link-from-banner")
    WebElement cehrtIALink;
    // 21. ACI EHR(CHPL) Lookup
    @FindBy(xpath = "//h5[contains(text(), 'Certified EHR Technology Lookup Tool')]")
    WebElement ehrOptionalText;
    // 22. ACI Combination Information Verification
    @FindBy(id = "combo-selected-text")
    WebElement combinationInformationTxt;

    public F_ACIPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // 1. Logos validation
    public WebElement getQPPLogo() {
        return qpplogo;
    }

    public WebElement getcmsLogo() {
        return cmslogo;
    }

    // 2. Header Elements
    public WebElement getMyAccount() {
        return myaccount;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getConfirmLogout() {
        return confirm;
    }

    // 3. Text "Quality"
    public WebElement assertACITxt() {
        return acitxt;
    }

    // 4. Left hand navigation bar elements

    public WebElement getAccountDashboard() {
        return accountDashboard;
    }

    public WebElement getConnectedClinicians() {
        return connectedClinicians;
    }

    public WebElement getGroupDashboard() {
        return groupDashboard;
    }

    public WebElement getQuality() {
        return qualityNavigation;
    }

    public WebElement getACI() {
        return aciNavigation;
    }

    public WebElement getIA() {
        return iaNavigation;
    }

    public WebElement closeGroupChevron() {
        return groupReportDD;
    }

    public WebElement getCollapseButton() {
        return collapsebtn;
    }

    // 5. Toolbar Buttons
    // a) Full Instructions
    public WebElement openFullInstructions() {
        return openFullInstructions;
    }

    public WebElement closeFullInstructions() {
        return closeFullInstructions;
    }

    public WebElement titleFullInstructions() {
        return titleFullInstructions;
    }

    // b) File Upload
    public WebElement openFileUpload() {
        return openFileUpload;
    }

    public WebElement getDragDropTxt() {
        return dragDropTxt;
    }

    public WebElement closeFileUpload() {
        return closeFileUpload;
    }

    // c) Delete Category Data
    public WebElement openDeleteData() {
        return deleteData;
    }

    public WebElement confirmDeleteData() {
        return confirmDelete;
    }

    // 6. Performance Period window
    public WebElement enterStartDate() {
        return startDate;
    }

    public WebElement enterEndDate() {
        return endDate;
    }

    public WebElement getPerfHelp() {
        return perfPopup;
    }

    // 7. Hide/Show Button
    public WebElement getHide() {
        return hide;
    }

    public WebElement getShow() {
        return show;
    }

    // 8. Electronic Health Records Lookup

    // 9. ACI Track selection buttons
    public WebElement getTransitionACI() {
        return transitionACI;
    }

    public WebElement getRegularACI() {
        return regularACI;
    }

    public WebElement getComboACI() {
        return comboACI;
    }

    // 10. Radio Buttons in the Attestation Statement
    public WebElement attestACI_INFBLO_1() {
        return ACI_INFBLO_1_Yes;
    }

    public WebElement unattestACI_INFBLO_1() {
        return ACI_INFBLO_1_No;
    }

    public WebElement attestACI_ONCDIR_1() {
        return ACI_ONCDIR_1_Yes;
    }

    public WebElement unattestACI_ONCDIR_1() {
        return ACI_ONCDIR_1_No;
    }

    public WebElement attestACI_ONCACB_1() {
        return ACI_ONCACB_1_Yes;
    }

    public WebElement UNattestACI_ONCACB_1() {
        return ACI_ONCACB_1_No;
    }

    // 11. Advancing Care Information Category Score
    public WebElement getACIScore() {
        return ACIScore;
    }

    // 12. ACI Measurement Set - "2017 Transition ACI Score"
    // a) Required for Base Score
    public WebElement getNumACI_TRANS_EP_1() {
        return NumACI_TRANS_EP_1;
    }

    public WebElement getDenACI_TRANS_EP_1() {
        return DenACI_TRANS_EP_1;
    }

    public WebElement getYesACI_TRANS_PPHI_1() {
        return YesACI_TRANS_PPHI_1;
    }

    public WebElement getNumACI_TRANS_PEA_1() {
        return NumACI_TRANS_PEA_1;
    }

    public WebElement getDenACI_TRANS_PEA_1() {
        return DenACI_TRANS_PEA_1;
    }

    public WebElement getNumACI_TRANS_HIE_1() {
        return NumACI_TRANS_HIE_1;
    }

    public WebElement getDenACI_TRANS_HIE_1() {
        return DenACI_TRANS_HIE_1;
    }

    // b) Optional Performance Score
    public WebElement getYesACI_TRANS_PHCDRR_1() {
        return YesACI_TRANS_PHCDRR_1;
    }

    public WebElement getNumACI_TRANS_PSE_1() {
        return NumACI_TRANS_PSE_1;
    }

    public WebElement getDenACI_TRANS_PSE_1() {
        return DenACI_TRANS_PSE_1;
    }

    public WebElement getNumACI_TRANS_SM_1() {
        return NumACI_TRANS_SM_1;
    }

    public WebElement getDenACI_TRANS_SM_1() {
        return DenACI_TRANS_SM_1;
    }

    public WebElement getNumACI_TRANS_PEA_2() {
        return NumACI_TRANS_PEA_2;
    }

    public WebElement getDenACI_TRANS_PEA_2() {
        return DenACI_TRANS_PEA_2;
    }

    public WebElement getNumACI_TRANS_MR_1() {
        return NumACI_TRANS_MR_1;
    }

    public WebElement getDenACI_TRANS_MR_1() {
        return DenACI_TRANS_MR_1;
    }

    // c) Additional Registry Bonus
    public WebElement getYesACI_TRANS_PHCDRR_2() {
        return YesACI_TRANS_PHCDRR_2;
    }

    public WebElement getYesACI_TRANS_PHCDRR_3() {
        return YesACI_TRANS_PHCDRR_3;
    }

    // d) CEHRT Used
    public WebElement getYesACI_IACEHRT_1() {
        return YesACI_IACEHRT_1;
    }

    public WebElement getContinueCEHRTPopup() {
        return ContinueCEHRTPopup;
    }

    // 13. Category Score
    public WebElement getCategorySuccess() {
        return categorySuccess;
    }

    // 14. Green Toaster popup
    public WebElement getGreenToaster() {
        return greenToaster;
    }

    // 15. Exclusion Checkbox
    // a) "Transition ACI Measures"
    public WebElement checkACI_TRANS_LVPP_1() {
        return checkACI_TRANS_LVPP_1;
    }

    public WebElement checkACI_TRANS_LVOTC_1() {
        return checkACI_TRANS_LVOTC_1;
    }

    // b) "Regular ACI Measures"
    public WebElement checkACI_LVPP_1() {
        return checkACI_LVPP_1;
    }

    public WebElement checkACI_LVOTC_1() {
        return checkACI_LVOTC_1;
    }

    public WebElement checkACI_LVITC_1() {
        return checkACI_LVITC_1;
    }

    // 16. ACI Help icon
    public WebElement getPreAttestPopup() {
        return preattestPopup;
    }

    public WebElement getPrePopupTxt() {
        return preattestPopupTxt;
    }

    public WebElement getBasePopup() {
        return basePopup;
    }

    public WebElement getbasepopupTxt() {
        return basePopupTxt;
    }

    public WebElement getOptionalPopup() {
        return optionalPopup;
    }


    public WebElement getBonusPopup() {
        return bonusPopup;
    }


    public WebElement getACICEHRTPopup() {
        return aciCEHRTPopup;
    }


    // 17. Performance Score
    // a) "Transition ACI Measures"
    public WebElement getPerformanceACI_TRANS_EP_1() {
        return performanceACI_TRANS_EP_1;
    }

    public WebElement getPerformanceACI_TRANS_PPHI_1() {
        return performanceACI_TRANS_PPHI_1;
    }

    public WebElement getPerformanceACI_TRANS_PEA_1() {
        return performanceACI_TRANS_PEA_1;
    }

    public WebElement getPerformanceACI_TRANS_HIE_1() {
        return performanceACI_TRANS_HIE_1;
    }

    public WebElement getPerformanceACI_TRANS_PHCDRR_1() {
        return performanceACI_TRANS_PHCDRR_1;
    }

    public WebElement getPerformanceACI_TRANS_PSE_1() {
        return performanceACI_TRANS_PSE_1;
    }

    public WebElement getPerformanceACI_TRANS_SM_1() {
        return performanceACI_TRANS_SM_1;
    }

    public WebElement getPerformanceACI_TRANS_PEA_2() {
        return performanceACI_TRANS_PEA_2;
    }

    public WebElement getPerformanceACI_TRANS_MR_1() {
        return performanceACI_TRANS_MR_1;
    }

    // b) "Regular ACI Measures"

    // 18. Bonus Score
    // a) "Transition ACI Measures"
    public WebElement getBonusACI_TRANS_PHCDRR_2() {
        return bonusACI_TRANS_PHCDRR_2;
    }

    public WebElement getBonusACI_TRANS_PHCDRR_3() {
        return bonusACI_TRANS_PHCDRR_3;
    }

    public WebElement getBonusACI_IACEHRT_1() {
        return bonusACI_IACEHRT_1;
    }

    // b) "Regular ACI Measures"

    // 19. ACI Yellow Banners
    public WebElement getPerfYellow() {
        return perfYellow;
    }

    public WebElement getBaseYellow() {
        return baseYellow;
    }

    public WebElement getOptionalYellow() {
        return optionalYellow;
    }

    public WebElement getBonusYellow() {
        return bonusYellow;
    }

    public WebElement getCEHRTYellow() {
        return CEHRTYellow;
    }

    // 20. ACI CEHRT "Improvement Activities" anchor text
    public WebElement getCEHRTIALink() {
        return cehrtIALink;
    }

    // 21. ACI EHR(CHPL) Lookup

    public WebElement getEhrOptionalText() {
        return ehrOptionalText;
    }

    // 22. ACI Combination Information Verification
    public WebElement getACIComboTxt() {
        return combinationInformationTxt;
    }

}
