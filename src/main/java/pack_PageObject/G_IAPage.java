package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class G_IAPage {

    WebDriver driver;

    public G_IAPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

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

    // 3. Text "Improvement Activities"
    @FindBy(css = ".page-title")
    WebElement iatxt;

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

    @FindBy(css = ".popover-content")
    WebElement helpPopupTxt;

    // 7. Improvement Activities Category Score
    @FindBy(css = ".score")
    WebElement IAScore;

    // 8. Showing IA Activities
    @FindBy(css = ".info-showing")
    WebElement textActivities;

    // 9. Filters Drop-down button
    @FindBy(css = ".fa-chevron-down")
    WebElement filtersDD;

    @FindBy(id = "subcategories")
    WebElement textSubCategories;

    @FindBy(css = "div.col-lg-4:nth-child(2)")
    WebElement textWeightCEHRT;

    // Filters Checkbox selection
    @FindBy(css = "#cbSc1-achievingHealthEquity")
    WebElement achievingHealthEquity;

    @FindBy(css = "#cbSc1-behavioralAndMentalHealth")
    WebElement behavioralAndMentalHealth;

    @FindBy(css = "#cbSc1-beneficiaryEngagement")
    WebElement beneficiaryEngagement;

    @FindBy(css = "#cbSc1-careCoordination")
    WebElement careCoordination;

    @FindBy(css = "#cbSc2-emergencyResponseAndPreparedness")
    WebElement emergencyResponseAndPreparedness;

    @FindBy(css = "#cbSc2-expandedPracticeAccess")
    WebElement expandedPracticeAccess;

    @FindBy(css = "#cbSc2-patientSafetyAndPracticeAssessment")
    WebElement patientSafetyAndPracticeAssessment;

    @FindBy(css = "#cbSc2-populationManagement")
    WebElement populationManagement;

    @FindBy(css = "#cbWt-medium")
    WebElement medium;

    @FindBy(css = "#cbWt-high")
    WebElement high;

    @FindBy(css = "#cbBs-true")
    WebElement cehrtEligible;

    @FindBy(css = ".clear-filters")
    WebElement clearAllFilters;

    // 10. Search IA Activities field
    @FindBy(css = ".search-field")
    WebElement searchActivities;

    @FindBy(css = ".clear")
    WebElement clearActivities;

    // 11. IA Measurement Set
    @FindBy(css = "button.IA_PCMH")
    WebElement IA_PCMH;

    @FindBy(css = "#pcmh-btn-IA_PCMH")
    WebElement IA_PCMHpopup;

    // 12. Green Toaster popup
    @FindBy(css = "#toasty > ng2-toast:nth-child(1)")
    WebElement greenToaster;

    // 13. Category Score Success
    @FindBy(css = ".score-info > div:nth-child(2)")
    WebElement categorySuccess;

    // 14. IA Performance Period Yellow Banner
    @FindBy(css = ".notification")
    WebElement yellowBanner;


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
    public WebElement assertIATxt() {
        return iatxt;
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

    public WebElement closeFileUpload() {
        return closeFileUpload;
    }

    public WebElement getDragDropTxt() { return dragDropTxt; }

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

    public WebElement getPopupTxt() { return helpPopupTxt; }

    // 7. Improvement Activities Category Score
    public WebElement getIAScore() {
        return IAScore;
    }

    // 8. Showing 92 Activities
    public WebElement getActivitiesShowing() {
        return textActivities;
    }

    // 9. Filters Drop-down button
    public WebElement openFiltersDD() {
        return filtersDD;
    }

    public WebElement getSubCategoriesTxt() { return textSubCategories; }

    public WebElement getTextWeightCEHRT() { return textWeightCEHRT; }

    // Filters Checkbox selection
    public WebElement getAchievingHealthEquity() {
        return achievingHealthEquity;
    }

    public WebElement getBehavioralAndMentalHealth() {
        return behavioralAndMentalHealth;
    }

    public WebElement getBeneficiaryEngagement() {
        return beneficiaryEngagement;
    }

    public WebElement getCareCoordination() {
        return careCoordination;
    }

    public WebElement getEmergencyResponseAndPreparedness() {
        return emergencyResponseAndPreparedness;
    }

    public WebElement getExpandedPracticeAccess() {
        return expandedPracticeAccess;
    }

    public WebElement getPatientSafetyAndPracticeAssessment() {
        return patientSafetyAndPracticeAssessment;
    }

    public WebElement getPopulationManagement() {
        return populationManagement;
    }

    public WebElement getMedium() {
        return medium;
    }

    public WebElement getHigh() {
        return high;
    }

    public WebElement getCEHRTEligible() {
        return cehrtEligible;
    }

    public WebElement getClearAllFilters() {
        return clearAllFilters;
    }

    // 10. Search IA Activities field
    public WebElement accessIASearch() {
        return searchActivities;
    }

    public WebElement clearIASearch() {
        return clearActivities;
    }

    // 11. IA Measurement Set
    public WebElement attestIA_PCMH() {
        return IA_PCMH;
    }

    public WebElement getIA_PCMHpopup() {
        return IA_PCMHpopup;
    }

    // 12. Green Toaster popup
    public WebElement getGreenToaster() {
        return greenToaster;
    }

    // 13. Category Score
    public WebElement getCategorySuccess() {
        return categorySuccess;
    }

    // 14. IA Performance Period Yellow Banner
    public WebElement getYellowBanner() { return yellowBanner; }
}


