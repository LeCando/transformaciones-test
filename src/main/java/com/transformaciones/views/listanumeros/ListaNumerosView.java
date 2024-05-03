package com.transformaciones.views.listanumeros;

import com.transformaciones.views.MainLayout;
import com.transformaciones.views.models.Numero;
import com.transformaciones.views.Utils.Util;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.aspectj.weaver.Utils;

import java.util.List;

@PageTitle("listaNumeros")
@Route(value = "lista-numeros", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class ListaNumerosView extends Composite<VerticalLayout> {

    Numero numero1=new Numero();
    public ListaNumerosView() {
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Calcular un nuevo número");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> UI.getCurrent().navigate("view-calculos"));
        getContent().add(buttonPrimary);

        Grid<Numero> grid = new Grid<>(Numero.class, false);
        grid.addColumn(Numero::getNumero).setHeader("Decimal").setSortable(true).setAutoWidth(true);
        grid.addColumn(Numero::getBinario).setHeader("Binario").setSortable(true).setAutoWidth(true);
        grid.addColumn(Numero::getHexadecimal).setHeader("Hexadecimal").setSortable(true).setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(numero -> {
                    // Botón para eliminar
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));
                    botonBorrar.addClickListener(e -> {
                     Util.listaNumero.remove(numero);
                        grid.getDataProvider().refreshAll();
                    });

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Numero> numeros = Util.listaNumero ;
        grid.setItems(numeros);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);
    }

}

