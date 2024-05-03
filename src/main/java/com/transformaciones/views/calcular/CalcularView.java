package com.transformaciones.views.calcular;

import com.transformaciones.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Calcular")
@Route(value = "view-calculos", layout = MainLayout.class)
@Uses(Icon.class)
public class CalcularView extends Composite<VerticalLayout> {

    public CalcularView() {
        TextField textField = new TextField();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        textField.setLabel("Ingrese el número decimal:");
        textField.setWidth("min-content");
        buttonPrimary.setText("Calcular");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(textField);
        getContent().add(buttonPrimary);
        buttonPrimary.addClickListener(e -> UI.getCurrent().navigate("lista-numeros"));



    }
}
