package com.example.test;

import com.example.test.entity.MyCounterEntity;
import com.example.test.repositories.MyRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("main")
public class MainView extends VerticalLayout {
    @Autowired
    private MyRepository myRepository;

    public MainView(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

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
            myRepository.save(myCounterEntity);
            System.out.println(myCounterEntity);
        });
        add(button);

        Button buttonSave = new Button("Сохранить");
        buttonSave.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(countField.getValue());
            myRepository.save(myCounterEntity);
            System.out.println(myCounterEntity);
        });
        add(buttonSave);

    }
}
