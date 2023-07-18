package com.example.test;

import com.example.test.entity.MyCounterEntity;
import com.example.test.repositories.MyRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;


/**
 * Использование биндера считаю нецелесообразным, так как количество изменяемых переменных равно 1.
 * И в случае, если пользователь будет ошибаться в воде значения, в числовом поле переменная постоянно
 * будет обновляться, то есть постоянно обращение к БД.
 * Было принято решение воспользоваться отдельной кнопокой для сохранения.
 */
@Route("main")
public class MainView extends VerticalLayout {

    private MyRepository myRepository;

    public MainView(MyRepository myRepository) {
        this.myRepository = myRepository;
        IntegerField countField = new IntegerField();
        MyCounterEntity myCounterEntity = new MyCounterEntity(0);
        countField.setValue(myCounterEntity.getMyCounter());
        add(countField);

        Button button = new Button("Увеличить");
        button.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(myCounterEntity.getMyCounter() + 1);
            countField.setValue(myCounterEntity.getMyCounter());
            this.myRepository.save(myCounterEntity);
        });
        add(button);

        Button buttonSave = new Button("Сохранить");
        buttonSave.addClickListener(clickEvent -> {
            myCounterEntity.setMyCounter(countField.getValue());
            this.myRepository.save(myCounterEntity);
        });
        add(buttonSave);

    }
}
