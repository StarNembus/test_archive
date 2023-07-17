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
    MyCounterEntity myCounterEntity;
    public MainView() {
        add(new NativeLabel("Your code here"));
        IntegerField countField = new IntegerField();
        myCounterEntity = new MyCounterEntity(0);
        countField.setValue(myCounterEntity.getMyCounter());
//        countField.setStepButtonsVisible(true);
        add(countField);

        Button button = new Button("Увеличить");
        button.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(1);
            countField.setValue(myCounterEntity.getMyCounter());
        });
        add(button);

        Button buttonSave = new Button("Сохранить");
        buttonSave.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(myCounterEntity.getMyCounter());
        });
        add(buttonSave);
        System.out.println(buttonSave);
    }
}
