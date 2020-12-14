package com.edgedx.covid.views;

import static com.edgedx.covid.views.InitialView.NAV;
import static com.vaadin.flow.server.VaadinSession.getCurrent;
import static java.lang.Boolean.TRUE;

import org.springframework.beans.factory.annotation.Autowired;

import com.edgedx.covid.model.ClinicalInformation;
import com.edgedx.covid.model.LaboratoryDiagnosis;
import com.edgedx.covid.model.PatientInformation;
import com.edgedx.covid.model.SpecimenInformation;
import com.edgedx.covid.model.SurveyWrapper;
import com.edgedx.covid.repository.ClinicalInformationRepository;
import com.edgedx.covid.repository.LaboratoryDiagnosisRepository;
import com.edgedx.covid.repository.PatientInformationRepository;
import com.edgedx.covid.repository.SpecimenInformationRepository;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinSession;

@Route(value = NAV)
@PWA(name = "Case investigation form for 2019 Novel Coronavirus (COVID-19)", startPath = "", shortName = "COVID-19 Form")
@PageTitle(value = "Case investigation form for 2019 Novel Coronavirus (COVID-19)")
public class InitialView extends VerticalLayout implements RouterLayout, BeforeEnterObserver {

	@Autowired
	PatientInformationRepository patientInfoRepo;

	@Autowired
	ClinicalInformationRepository clinicalInfoRepo;

	@Autowired
	LaboratoryDiagnosisRepository laboratoryDiagnosisRepository;

	@Autowired
	SpecimenInformationRepository specimenInformationRepository;

	public static final String NAV = "";

	public static final String ATTRIBUTE_DATA = "patientData";
	public static final String ATTRIBUTE_IS_AUTH = "auth";

	public InitialView() {
		setSizeFull();
		setAlignItems(Alignment.CENTER);

		H2 welcome = new H2("Case investigation form for 2019 Novel Coronavirus (COVID-19)");
		welcome.getElement().getStyle().set("color", "#1e7db8");
		welcome.getElement().getStyle().set("text-align", "center");
		welcome.setWidthFull();
		welcome.setHeight("30%");
		add(welcome);

		H5 note = new H5("Please type the specimen ID");
		note.getElement().getStyle().set("color", "#1e7db8");
		note.getElement().getStyle().set("text-align", "center");
		add(note);

		TextField identifierField = new TextField();

		Button search = new Button("Search");
		search.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		search.addClickShortcut(Key.ENTER);
		search.addClickListener(e -> {
			SurveyWrapper data = null;

			PatientInformation patientInfo = patientInfoRepo.findBySpecimenId(identifierField.getValue());
			if (patientInfo != null) {
				SpecimenInformation specimenInfo = specimenInformationRepository.findByPatientId(patientInfo.getId());
				ClinicalInformation clinicalInfo = clinicalInfoRepo.findByPatientId(patientInfo.getId());
				LaboratoryDiagnosis labDiagnosis = laboratoryDiagnosisRepository.findByPatientId(patientInfo.getId());
				data = new SurveyWrapper(patientInfo, specimenInfo, clinicalInfo, labDiagnosis);
			}

			if (data != null) {
				VaadinSession vaadinSession = getCurrent();
				vaadinSession.setAttribute(ATTRIBUTE_DATA, data);
				vaadinSession.setAttribute(ATTRIBUTE_IS_AUTH, TRUE);

				this.getUI().ifPresent(ui -> ui.navigate("form"));
			} else {
				Notification notification = new Notification(
						"Identifier is not registered in the database. Please try again");
				notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
				notification.setPosition(Position.BOTTOM_CENTER);
				notification.setDuration(3000);
				notification.open();
				identifierField.clear();
			}

		});
		add(identifierField);
		add(search);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub

	}
}
