package com.edgedx.covid.views;

import static com.edgedx.covid.views.InitialView.ATTRIBUTE_DATA;
import static com.edgedx.covid.views.InitialView.ATTRIBUTE_IS_AUTH;
import static com.edgedx.covid.views.MainView.NAV;
import static com.vaadin.flow.server.VaadinSession.getCurrent;
import static java.lang.Boolean.FALSE;
import static java.util.Optional.ofNullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.edgedx.covid.model.BinaryOption;
import com.edgedx.covid.model.ClinicalInformation;
import com.edgedx.covid.model.LaboratoryDiagnosis;
import com.edgedx.covid.model.PatientInformation;
import com.edgedx.covid.model.SpecimenInformation;
import com.edgedx.covid.model.SurveyWrapper;
import com.edgedx.covid.util.Constants;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route(value = NAV)
@Theme(value = Lumo.class)
@PageTitle(value = "Case investigation form for 2019 Novel Coronavirus (COVID-19)")
public class MainView extends VerticalLayout implements RouterLayout, BeforeEnterObserver {

	public static final String NAV = "form";

	private final SurveyWrapper wrapper;

	private PatientInformation data;

	private SpecimenInformation specimenData;

	private ClinicalInformation clinicalData;

	private LaboratoryDiagnosis labDiagnosis;

	public MainView() {
		VaadinSession vaadinSession = VaadinSession.getCurrent();
		wrapper = (SurveyWrapper) vaadinSession.getAttribute(ATTRIBUTE_DATA);

		setAlignItems(Alignment.CENTER);
		setWidthFull();
		setMargin(false);
		if (wrapper != null) {
			data = wrapper.getPatientInformation();
			specimenData = wrapper.getSpecimenInformation();
			clinicalData = wrapper.getClinicalInformation();
			labDiagnosis = wrapper.getLaboratoryDiagnosis();
			buildSection1();
			buildSection2();
			buildSection3();
			buildSection4();
			try {
				buildSectionImages();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Button closeButton = new Button("Back");
			closeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			closeButton.getElement().getStyle().set("color", "#04afee");
			closeButton.addClickListener(e -> {
				closeButton.getUI().ifPresent(ui -> ui.navigate(""));
			});
			add(closeButton);

		} else {
			UI.getCurrent().navigate("");
		}

	}

	private void buildSectionImages() throws FileNotFoundException {
		Label section5Title = new Label("RDT images");
		section5Title.getElement().getStyle().set("background-color", "#04afee");
		section5Title.getElement().getStyle().set("color", "white");
		section5Title.getElement().getStyle().set("padding-left", "0.5em");
		section5Title.getElement().getStyle().set("padding-top", "0.5em");
		section5Title.getElement().getStyle().set("padding-bottom", "0.5em");
		section5Title.getElement().getStyle().set("font-weight", "bold");
		section5Title.setWidthFull();
		add(section5Title);

		if (data.getImages() != null) {
			for (String imageName : data.getImages()) {
				File file = new File(Constants.IMAGES_FOLDER_PATH + imageName);
				System.out.println("Expecting to find file from " + file.getAbsolutePath());

				Image image = new Image(new StreamResource(imageName, () -> {
					try {
						return new FileInputStream(file);
					} catch (FileNotFoundException e) {
						// file not found
						e.printStackTrace();
					}
					return null;
				}), imageName);
				image.setMaxWidth("100%");
				image.setMaxHeight("500px");
				add(image);
			}
		}
	}

	private void buildSection1() {
		Label section1Title = new Label("Client/Patient information");
		section1Title.getElement().getStyle().set("background-color", "#04afee");
		section1Title.getElement().getStyle().set("color", "white");
		section1Title.getElement().getStyle().set("padding-left", "0.5em");
		section1Title.getElement().getStyle().set("padding-top", "0.5em");
		section1Title.getElement().getStyle().set("padding-bottom", "0.5em");
		section1Title.getElement().getStyle().set("font-weight", "bold");

		section1Title.setWidthFull();
		add(section1Title);

		FormLayout layoutSection1 = new FormLayout();
		layoutSection1.setSizeFull();
		layoutSection1.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		TextField fullName = new TextField();
		fullName.setSizeFull();
		fullName.setLabel("Full name");
		fullName.setReadOnly(true);
		if (data.getFullName() != null)
			fullName.setValue(data.getFullName());
		layoutSection1.add(fullName);

		TextField sex = new TextField();
		sex.setSizeFull();
		sex.setLabel("Sex");
		sex.setReadOnly(true);

		layoutSection1.add(sex);
		if (data.getSex() != null)
			sex.setValue(data.getSex().getDescription());

		TextField age = new TextField();
		age.setSizeFull();
		age.setLabel("Age");
		age.setReadOnly(true);
		layoutSection1.add(age);
		if (data.getAge() != null)
			age.setValue(data.getAge().toString());

		TextField nationality = new TextField();
		nationality.setSizeFull();
		nationality.setLabel("Nationality");
		nationality.setReadOnly(true);

		if (data.getNationality() != null)
			nationality.setValue(data.getNationality().getValue());
		layoutSection1.add(nationality);

		TextField phoneNumber = new TextField();
		phoneNumber.setSizeFull();
		phoneNumber.setLabel("Phone Number");
		phoneNumber.setReadOnly(true);
		layoutSection1.add(phoneNumber);
		if (data.getPhoneNumber() != null)
			phoneNumber.setValue(data.getPhoneNumber());

		TextField passportNumber = new TextField();
		passportNumber.setSizeFull();
		passportNumber.setLabel("Passport Number");
		passportNumber.setReadOnly(true);
		layoutSection1.add(passportNumber);
		if (data.getPhoneNumber() != null)
			passportNumber.setValue(data.getPassportNumber());

		TextField residence = new TextField();
		residence.setSizeFull();
		residence.setLabel("Residence city/town of the patient");
		residence.setReadOnly(true);
		layoutSection1.add(residence);
		if (data.getResidenceCity() != null)
			residence.setValue(data.getResidenceCity());

		TextField region = new TextField();
		region.setSizeFull();
		region.setLabel("Region");
		region.setReadOnly(true);
		layoutSection1.add(region);
		if (data.getRegion() != null)
			region.setValue(data.getRegion());

		TextField specimenCollectionLocation = new TextField();
		specimenCollectionLocation.setSizeFull();
		specimenCollectionLocation.setLabel("Location of specimen collection (Health facility, quarantine)");
		specimenCollectionLocation.setReadOnly(true);
		layoutSection1.add(specimenCollectionLocation);
		if (data.getSpecimenCollectionLocation() != null)
			specimenCollectionLocation.setValue(data.getSpecimenCollectionLocation());

		TextField specimenId = new TextField();
		specimenId.setSizeFull();
		specimenId.setLabel("Specimen ID");
		specimenId.setReadOnly(true);
		layoutSection1.add(specimenId);
		if (data.getSpecimenId() != null)
			specimenId.setValue(data.getSpecimenId());

		add(layoutSection1);
	}

	private void buildSection2() {
		Label section2Title = new Label("Clinical/Other information");
		section2Title.getElement().getStyle().set("background-color", "#04afee");
		section2Title.getElement().getStyle().set("color", "white");
		section2Title.getElement().getStyle().set("padding-left", "0.5em");
		section2Title.getElement().getStyle().set("padding-top", "0.5em");
		section2Title.getElement().getStyle().set("padding-bottom", "0.5em");
		section2Title.getElement().getStyle().set("font-weight", "bold");

		section2Title.setWidthFull();
		add(section2Title);

		FormLayout layoutSection2 = new FormLayout();
		layoutSection2.setSizeFull();
		layoutSection2.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		TextField patientTravelled = new TextField();
		patientTravelled.setSizeFull();
		patientTravelled.setLabel("Has the patient/client had a recent history of travelling to an affected area/s?");
		patientTravelled.setReadOnly(true);
		layoutSection2.add(patientTravelled);
		layoutSection2.setColspan(patientTravelled, 3);
		if (clinicalData.getPatientTravelled() != null) {
			patientTravelled.setValue(clinicalData.getPatientTravelled().getDescription());
			if (clinicalData.getPatientTravelled().equals(BinaryOption.YES)) {

				TextField country = new TextField();
				country.setSizeFull();
				country.setLabel("Country");
				country.setReadOnly(true);
				layoutSection2.add(country);
				if (clinicalData.getCountry() != null)
					country.setValue(clinicalData.getCountry().getCountryName());

				TextField city = new TextField();
				city.setSizeFull();
				city.setLabel("City");
				city.setReadOnly(true);
				layoutSection2.add(city);
				if (clinicalData.getCity() != null)
					city.setValue(clinicalData.getCity());

				DatePicker returnDate = new DatePicker();
				returnDate.setSizeFull();
				returnDate.setLabel("Return date");
				returnDate.setReadOnly(true);
				layoutSection2.add(returnDate);
				if (clinicalData.getReturnDate() != null)
					returnDate.setValue(clinicalData.getReturnDate());

			}
		}

		TextField testingReason = new TextField();
		testingReason.setSizeFull();
		testingReason.setLabel("Reason for testing");
		testingReason.setReadOnly(true);
		layoutSection2.add(testingReason);
		if (clinicalData.getReasonForTesting() != null)
			testingReason.setValue(clinicalData.getReasonForTesting().getDescription());

		TextField requestingPerson = new TextField();
		requestingPerson.setSizeFull();
		requestingPerson.setLabel("Requesting Physician/Person");
		requestingPerson.setReadOnly(true);
		layoutSection2.add(requestingPerson);
		if (clinicalData.getRequestingPhysician() != null)
			requestingPerson.setValue(clinicalData.getRequestingPhysician());

		TextField requestingPhone = new TextField();
		requestingPhone.setSizeFull();
		requestingPhone.setLabel("Phone");
		requestingPhone.setReadOnly(true);
		layoutSection2.add(requestingPhone);
		if (clinicalData.getRequestingPhone() != null)
			requestingPhone.setValue(clinicalData.getRequestingPhone());

		add(layoutSection2);
	}

	private void buildSection3() {
		Label section3Title = new Label("Specimen information");
		section3Title.getElement().getStyle().set("background-color", "#04afee");
		section3Title.getElement().getStyle().set("color", "white");
		section3Title.getElement().getStyle().set("padding-left", "0.5em");
		section3Title.getElement().getStyle().set("padding-top", "0.5em");
		section3Title.getElement().getStyle().set("padding-bottom", "0.5em");
		section3Title.getElement().getStyle().set("font-weight", "bold");

		section3Title.setWidthFull();
		add(section3Title);

		FormLayout section3Layout = new FormLayout();
		section3Layout.setSizeFull();

		TextField sampleType = new TextField();
		sampleType.setSizeFull();
		sampleType.setLabel("Sample type");
		section3Layout.add(sampleType);
		if (specimenData.getSampleType() != null)
			sampleType.setValue(specimenData.getSampleType());
		sampleType.setReadOnly(true);

		DateTimePicker specimenCollectiondatetime = new DateTimePicker();
		specimenCollectiondatetime.setSizeFull();
		specimenCollectiondatetime.setLabel("Specimen collection date and time");
		section3Layout.add(specimenCollectiondatetime);
		if (specimenData.getSpecimenCollectionTime() != null)
			specimenCollectiondatetime.setValue(specimenData.getSpecimenCollectionTime());
		specimenCollectiondatetime.setReadOnly(true);

		DatePicker receivedAtLabDate = new DatePicker();
		receivedAtLabDate.setSizeFull();
		receivedAtLabDate.setLabel("Received at Lab date");
		section3Layout.add(receivedAtLabDate);
		if (specimenData.getReceivedLabDate() != null)
			receivedAtLabDate.setValue(specimenData.getReceivedLabDate());
		receivedAtLabDate.setReadOnly(true);

		TextField collectorPhone = new TextField();
		collectorPhone.setSizeFull();
		collectorPhone.setLabel("Phone");
		section3Layout.add(collectorPhone);
		if (specimenData.getCollectorPhone() != null)
			collectorPhone.setValue(specimenData.getCollectorPhone());
		collectorPhone.setReadOnly(true);

		add(section3Layout);

	}

	private void buildSection4() {

		Label section4Title = new Label("Laboratory Diagnosis");
		section4Title.getElement().getStyle().set("background-color", "#04afee");
		section4Title.getElement().getStyle().set("color", "white");
		section4Title.getElement().getStyle().set("padding-left", "0.5em");
		section4Title.getElement().getStyle().set("padding-top", "0.5em");
		section4Title.getElement().getStyle().set("padding-bottom", "0.5em");
		section4Title.getElement().getStyle().set("font-weight", "bold");

		section4Title.setWidthFull();
		add(section4Title);

		FormLayout section4Layout = new FormLayout();
		section4Layout.setSizeFull();

		TextField testRequested = new TextField();
		testRequested.setSizeFull();
		testRequested.setLabel("Test Requested");
		section4Layout.add(testRequested);
		if (labDiagnosis.getTestRequested() != null)
			testRequested.setValue(labDiagnosis.getTestRequested());
		testRequested.setReadOnly(true);

		TextField testProtocol = new TextField();
		testProtocol.setSizeFull();
		testProtocol.setLabel("Test Protocol");
		section4Layout.add(testProtocol);
		if (labDiagnosis.getTestProtocol() != null)
			testProtocol.setValue(labDiagnosis.getTestProtocol());
		testProtocol.setReadOnly(true);

		TextField testMethod = new TextField();
		testMethod.setSizeFull();
		testMethod.setLabel("Test Method");
		section4Layout.add(testMethod);
		if (labDiagnosis.getTestMethod() != null)
			testMethod.setValue(labDiagnosis.getTestMethod());
		testMethod.setReadOnly(true);

		TextField labResult = new TextField();
		labResult.setSizeFull();
		labResult.setLabel("Laboratory Result");
		section4Layout.add(labResult);
		if (labDiagnosis.getLabResult() != null)
			labResult.setValue(labDiagnosis.getLabResult());
		labResult.setReadOnly(true);

		TextField testDoneBy = new TextField();
		testDoneBy.setSizeFull();
		testDoneBy.setLabel("Test done by");
		section4Layout.add(testDoneBy);
		if (labDiagnosis.getTestDoneBy() != null)
			testDoneBy.setValue(labDiagnosis.getTestDoneBy());
		testDoneBy.setReadOnly(true);

		DatePicker diagnosisDate = new DatePicker();
		diagnosisDate.setSizeFull();
		diagnosisDate.setLabel("Diagnosis Date");
		section4Layout.add(diagnosisDate);
		if (labDiagnosis.getDiagnosisDate() != null)
			diagnosisDate.setValue(labDiagnosis.getDiagnosisDate());
		diagnosisDate.setReadOnly(true);

		TextField approvedBy = new TextField();
		approvedBy.setSizeFull();
		approvedBy.setLabel("Result approved and reported by");
		section4Layout.add(approvedBy);
		if (labDiagnosis.getResultApprovedBy() != null)
			approvedBy.setValue(labDiagnosis.getResultApprovedBy());
		approvedBy.setReadOnly(true);

		DatePicker date = new DatePicker();
		date.setSizeFull();
		date.setLabel("Date");
		section4Layout.add(date);
		if (labDiagnosis.getApprovedDate() != null)
			date.setValue(labDiagnosis.getApprovedDate());
		date.setReadOnly(true);

		add(section4Layout);

	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		String path = event.getLocation().getPath();

		Boolean isAuthenticated = ofNullable((Boolean) getCurrent().getAttribute(ATTRIBUTE_IS_AUTH)).orElse(FALSE);

		if ((!isAuthenticated) || (isAuthenticated && !path.equals("form"))) {
			event.rerouteTo(InitialView.class);
		}

	}
}
