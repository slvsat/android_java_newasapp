package sattar.androidnewsapp;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class DBContext {
    AppDatabase database;

    List<News> news;
    FragmentOne mContext;

    public void SetNews(List<News> nws){
        this.news = nws;
        mContext.setAdapter(news);
    }

    public DBContext(AppDatabase database, FragmentOne fragment){
        this.database = database;
        this.mContext = fragment;
    }

    public void GetDataAsync(){
        new DatabaseAsync().execute();
    }

    public void InsertNewsAsync(News nws){
        new InsertAsync().execute(nws);
    }

    public void DeleteNewsAsync(News news) { new DeleteAsync().execute(news); }

    public void DeleteAllAsync(){ new DeleteAllAsync().execute(); }

    private class DatabaseAsync extends AsyncTask<Void, Void, List<News>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Perform pre-adding operation here.
        }

        @Override
        protected List<News> doInBackground(Void... voids) {
            List<News> data = database.newsDao().getAll();
            return data;
        }

        @Override
        protected void onPostExecute(List<News> aVoid) {
            super.onPostExecute(aVoid);
            SetNews(aVoid);
            //To after addition operation here.
        }
    }

    private class InsertAsync extends AsyncTask<News, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(News ... crNews) {
            //Log.e("News", crNews[0].getTitle());

            database.newsDao().insert(crNews);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }
    }

    private  class DeleteAsync extends AsyncTask<News, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(News ... crNews) {
            database.newsDao().delete(crNews[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }
    }

    private class DeleteAllAsync extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();;
        }

        @Override
        protected Void doInBackground(Void ... voids){
            database.newsDao().nukeTable();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
        }
    }
}
