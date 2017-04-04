package com.example.macadoshus.quizer;

import java.util.ArrayList;

/**
 * Created by Macadoshus on 3/30/2017.
 */

public class CardInfo {

        private String title = new String();
        private ArrayList<String> questions = new ArrayList<>();

        CardInfo(){
            title = "A Card";
        }
        CardInfo(String title){
            this.title = title;
        }

        public void setTitle(String newTitle){
            this.title = newTitle;
        }
        public String getTitle(){
            return this.title;
        }

        public String getQuestions(int index){
            return questions.get(index);
        }
        public void addQuestions(String e){
            questions.add(e);
        }
        public void removeQuestions(String e){
            questions.remove(e);
        }
}
