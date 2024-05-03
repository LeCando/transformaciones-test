package com.transformaciones.views.calcular;

import com.transformaciones.views.MainLayout;
import com.transformaciones.views.Utils.Util;
import com.transformaciones.views.models.Numero;
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
    Numero numero1=new Numero();
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
        buttonPrimary.addClickListener(e -> {
            if (!textField.isEmpty()) {
                // Obtener el número ingresado y convertirlo a binario y hexadecimal
                int numeroDecimal = Integer.parseInt(textField.getValue());
                String binario = Integer.toBinaryString(numeroDecimal);
                String hexadecimal = Integer.toHexString(numeroDecimal).toUpperCase();

                // Crear un nuevo objeto Numero con los valores convertidos
                Numero nuevoNumero = new Numero(numeroDecimal, binario, hexadecimal);

                // Agregar el nuevo número a la lista y actualizar el grid
                Util.listaNumero.add(nuevoNumero);
                // Navegar a la vista de números después de calcular
                UI.getCurrent().navigate("lista-numeros");
            }
        });
    }

    }

