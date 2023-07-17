package com.example.test;

import com.example.entity.MyCounterEntity;
import com.example.repositories.MyRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;

import java.util.concurrent.atomic.AtomicInteger;


@Route("main")
public class MainView extends VerticalLayout {

    public MainView() {
        add(new NativeLabel("Your code here"));
        IntegerField countField = new IntegerField();
        MyCounterEntity myCounterEntity = new MyCounterEntity(0);
        countField.setValue(myCounterEntity.getMyCounter());
//        countField.setStepButtonsVisible(true);
        add(countField);

        Button button = new Button("Увеличить");
        button.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(myCounterEntity.getMyCounter() + 1);
            countField.setValue(myCounterEntity.getMyCounter());
            System.out.println(myCounterEntity);
        });
        add(button);

        Button buttonSave = new Button("Сохранить");
        buttonSave.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(countField.getValue());
            System.out.println(myCounterEntity);
        });
        add(buttonSave);

    }
}
