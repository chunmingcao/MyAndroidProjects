package com.caocm.android.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by caocm_000 on 12/9/2015.
 */
public class Question {
    private String text;
    private List options = new ArrayList();
    private int answer;

    public Question(String text){
        this.text = text;
    }
    public void addOption(String option){
        options.add(option);
    }

    public List getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getText() {
        return text;
    }
}
