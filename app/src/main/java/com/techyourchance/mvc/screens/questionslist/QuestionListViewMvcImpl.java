package com.techyourchance.mvc.screens.questionslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import java.util.ArrayList;
import java.util.List;


public class QuestionListViewMvcImpl implements QuestionsListAdapter.OnQuestionClickListener, QuestionListViewMvc {
    private View rootView;
    private ListView mLstQuestions;
    private QuestionsListAdapter mQuestionsListAdapter;
    private final List<Listener> mListeners=new ArrayList<>(1);


    public QuestionListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {

        rootView=inflater.inflate(R.layout.layout_questions_list,parent,false);
        mLstQuestions = findViewById(R.id.lst_questions);
        mQuestionsListAdapter = new QuestionsListAdapter(getContext(), this);
        mLstQuestions.setAdapter(mQuestionsListAdapter);

    }

    @Override
    public void registerListener(Listener listener){
        mListeners.add(listener);
    }

    @Override
    public void unRegisterListener(Listener listener){
        mListeners.remove(listener);
    }

    private <T extends View> T findViewById(int id) {

        return getRootView().findViewById(id);
    }

    private Context getContext(){

        return getRootView().getContext();
    }

    @Override
    public View getRootView(){

        return rootView;
    }
    @Override
    public void QuestionsBind(List<Question> questions){

        mQuestionsListAdapter.clear();
        mQuestionsListAdapter.addAll(questions);
        mQuestionsListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onQuestionClicked(Question question) {

        for(Listener listener:mListeners){
            listener.onQuestionClicked(question);
        }
    }
}
