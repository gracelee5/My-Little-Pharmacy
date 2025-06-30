package edu.sungshin.mlp_con;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.effect.Effect;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class RecommendItemMain extends Activity {
    private final String dbName = "SWMPDB";
    private final String tableName = "SWMPTABLE1111";

    private String names[];
    {
        names = new String[]{
                "피부보습엔 히알루론산",
                "피부비타민 레모나 핑크",
                "피부비타민 레모나 핑크케어",
                "피부빤짝스트레스제로",
                "피부생유산균 CJLP133",
                "피부생유산균 닥터플러스 CJLP133",
                "피부속히알루론산",
                "피부앤스피나",
                "피부에 좋아",
                "피부에 좋은 빨강석류",
                "피부에 집중",
                "피부엔 더(THE) 어린콜라겐",
                "피부N365",
                "피부N빨강석류",
                "피부건강 곤약 세라마이드"
        };
    }

    private String madeby[];
    {
        madeby = new String[]{
                "(주)알피바이오",
                "(주)경남제약",
                "(주)경남제약",
                "(주)비오팜",
                "(주)노바렉스",
                "(주)노바렉스",
                "(주)한국씨엔에스팜",
                "(주)에스에스바이오팜",
                "(주)비엘헬스케어 2공장",
                "(주)에이치엘사이언스",
                "(주)네이처텍",
                "(주)한국씨엔에스팜",
                "(주)코스맥스바이오",
                "(주)극동에치팜 주식회사 2공장",
                "(주)한국씨엔에스팜"
        };
    }

    private String effects[];
    {
        effects = new String[]{
                "<효과>\n① 피부보습에 도움을 줄 수 있음 \n ② 피부와 점막을 형성하고 기능을 유지하는데 필요 \n③ 상피세포의 성장과 발달에 필요 \n④ 결합조직 형성과 기능유지에 필요",
                "<효과>\n① 피부보습에 도움을 줄 수 있음 \n② 결합조직 형성과 기능유지에 필요 \n③ 철의 흡수에 필요 \n④ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n① 피부보습･자외선에 의한 피부손상으로부터 피부건강 유지에 도움을 줄 수 있음 \n② 결합조직 형성과 기능유지에 필요 \n③ 철의 흡수에 필요 \n④ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n[석류 농축 분말(기능성원료인정 제2018-8호)]\n ① 피부 보습에 도움을 줄 수 있음  \n② 자외선에 의한 피부 손상으로부터 피부건강을 유지하는데 도움을 줄 수 있음 \n[비타민 C] \n① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 유해산소로부터 세포를 보호하는데 필요 \n[테아닌] 스트레스로 인한 긴장완화에 도움을 줄 수 있음 \n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요",
                "<효과>\n[과채유래 유산균(L.plantarum CJLP133)]\n ① 면역과민반응에 의한 피부상태 개선에 도움을 줄 수 있음 \n② 유산균 증식 및 유해균 억제․배변활동 원활·장건강에 도움을 줄 수 있음",
                "<효과>\n① 정상적인 면역기능에 필요 \n② 정상적인 세포분열에 필요 \n③ 칼슘과 인이 흡수되고 이용되는데 필요 \n④ 면역과민반응에 의한 피부상태 개선에 도움을 줄 수 있음(생리활성기능 2등급) \n⑤ 유산균 증식 및 유해균 억제·배변활동 원활에 도움을 줄 수 있음",
                "<효과>\n피부보습에 도움을 줄 수 있음",
                "<효과>\n① 피부건강·항산화에 도움을 줄 수 있음 \n② 혈중 콜레스테롤 개선에 도움을 줄 수 있음",
                "<효과>\n[로즈마리 자몽 추출 복합물(Nutroxsun)(제2019-25호)] \n자외선에 의한 피부손상으로부터 피부건강을 유지하는데 도움을 줄 수 있음 \n[히알루론산] 피부보습에 도움을 줄 수 있음",
                "<효과>\n① 갱년기 여성의 건강에 도움을 줄 수 있음 \n② 피부보습에 도움을 줄 수 있음",
                "<효과>\n① 피부 보습에 도움을 줄 수 있음 \n② 자외선에 의한 피부손상으로부터 피부 건강을 유지하는데 도움을 줄 수 있음",
                "<효과>\n① 자외선에 의한 피부손상으로부터 피부건강을 유지하는데 도움을 줄 수 있음 \n② 피부보습에 도움을 줄 수 있음",
                "<효과>\n[로즈마리추출물등복합물] 자외선에 의한 피부손상으로부터 피부 건강 유지에 도움을 줄 수 있음 \n[히알루론산] 피부보습에 도움을 줄 수 있음 \n[비타민 C] \n① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n① 갱년기 여성의 건강에 도움을 줄 수 있음 \n② 피부보습에 도움을 줄 수 있음.",
                "<효과>\n[곤약감자추출물] 피부 보습에 도움을 줄 수 있음 \n[비타민 C] \n① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[아연] \n① 정상적인 면역기능에 필요 \n② 정상적인 세포분열에 필요"
        };
    }

    private String notice[];
    {
        notice = new String[]{
                "<주의사항>\n섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오.",
                "<주의사항>\n① 알레르기, 특이체질이신 경우 성분을 확인하신 후 섭취하시기 바랍니다. \n② 흡습의 우려가 있으니 개봉한 제품은 가급적 빨리 섭취하시기 바랍니다. \n③ 제품 개봉 또는 섭취 시 포장재에 의해 상처를 입을 수 있으니 주의하십시오.",
                "<주의사항>\n① 알레르기, 특이체질이신 경우 성분을 확인하신 후 섭취하시기 바랍니다. \n② 흡습의 우려가 있으니 개봉한 제품은 가급적 빨리 섭취하시기 바랍니다. \n③ 제품 개봉 또는 섭취 시 포장재에 의해 상처를 입을 수 있으니 주의하십시오.",
                "<주의사항>\n① 영·유아, 어린이, 임산부와 수유부는 섭취에 주의 \n② 에스트로겐 호르몬에 민감한 사람은 섭취에 주의 \n③ 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의 \n④ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 특정 성분에 알레르기가 있으신 분은 원료명을 확인 후 섭취하십시오. \n② 임산부, 수유부나 의약품을 섭취하시는 분은 제품을 드시기 전에 의사와 상담 후 섭취하십시오. \n③ 섭취량 및 섭취방법을 확인한 후 섭취하시고, 기타 제품관련 사항은 고객행복센터로 문의하십시오. \n④ 제품의 개봉이나 섭취시 상처를 입을 수 있으니 주의하시기 바랍니다. \n⑤ 분말형태이므로 7세 이하의 어린이가 섭취할 경우에는 보호자의 지도, 감독하에 섭취하십시오. \n⑥ 질환이 있거나 의약품 복용 시 전문가와 상담할 것 \n⑦ 알레르기 체질 등은 개인에 따라 과민반응을 나타낼 수 있음 \n⑧ 어린이가 함부로 섭취하지 않도록 일일섭취량 방법을 지도할 것 \n⑨ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것 \n② 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것 \n③ 특정질환, 특이체질, 알레르기체질, 임산부의 경우에는 간혹 개인에 따라 과민반응이 나타날 수 있으므로 원료를 확인하시고, 섭취 전에 전문가와 상담하시기 바랍니다.",
                "<주의사항>\n섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오.",
                "<주의사항>\n이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 영·유아, 어린이, 임산부 및 수유부는 섭취에 주의 \n② 특정질환(알레르기 체질 등)이 있는 분은 섭취에 주의 \n③ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것 \n④ 의약품(혈압강하제, 부정맥치료제, 고지혈증치료제, 항응고제 등)을 복용하시는 분은 섭취 전 의사와 상담",
                "<주의사항>\n① 어린이, 임산부와 수유부는 섭취를 피하는 것이 좋습니다. \n② 에스트로겐 호르몬에 민감한 사람은 섭취에 주의하시기 바랍니다.\n③ 특정 성분에 알레르기가 있으신 분은 원료명을 확인 후 섭취하십시오.\n④ 개봉 또는 섭취시 포장재에 의해 상처를 입을 수 있으니 주의하시기 바랍니다.",
                "<주의사항>\n섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오.",
                "<주의사항>\n① 특이체질, 알레르기 체질의 경우 성분을 확인하시고 섭취하여 주시기 바랍니다. \n② 어린이의 경우 섭취 시 목에 걸릴 우려가 있으니 보호자의 지도하에 섭취하십시오. \n③ 영·유아, 어린이, 임산부 및 수유부는 섭취에 주의하십시오. \n④ 특정질환(알레르기 체질 등)이 있는 분은 섭취에 주의하십시오. \n⑤ 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.",
                "<주의사항>\n① 섭취 시 목에 걸릴 수 있으므로 반드시 물과 함께 섭취하십시오. \n② 섭취 시 위장장애, 소화불량의 증상이 있을 경우 섭취를 중단하십시오. \n③ 개인의 신체 상태에 따라 이상 증상이 생길 경우 섭취를 중단하십시오. \n④ 특정 원료 성분에 알레르기 체질은 원료 성분을 확인 후 섭취하십시오. \n⑤ 영·유아, 어린이, 임산부 및 수유부는 섭취에 주의하십시오. \n⑥ 특정질환(알레르기 체질 등)이 있는 분은 섭취에 주의하십시오. \n⑦ 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오. \n⑧ 흡연자는 섭취 시 전문가와 상담하십시오. \n⑨ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있습니다.",
                "<주의사항>\n① 임산부, 수유부, 영유아는 섭취를 피하는 것이 좋습니다. \n② 에스트로겐 호르몬에 민감한 사람은 섭취에 주의하시기 바랍니다. \n③ 섭취 시 위장장애, 소화불량의 증상이 있을 경우 섭취를 중단하십시오. \n④ 개인의 신체 상태에 따라 이상 증상이 생길 경우 섭취를 중단하십시오. \n⑤ 섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오.\n⑥ 특정 원료 성분에 알레르기 체질은 원료 성분을 확인 후 섭취하십시오.\n⑦ 유통기한이 경과된 제품은 섭취하지 마십시오.\n⑧ 파우치포장 그대로 전자레인지에 가열하지 마십시오. \n⑨ 제품 개봉 또는 섭취시 포장재에 의해 다칠 우려가 있으니 주의하십시오.",
                "<주의사항>\n① 특이체질, 알레르기 체질의 경우 성분을 확인하시고 섭취하여 주시기 바랍니다.\n② 어린이의 경우 섭취 시 목에 걸릴 우려가 있으니 보호자의 지도하에 섭취하십시오.\n③ 임산부와 수유기 여성은 섭취를 피할 것"
        };
    }

    ArrayList<HashMap<String, String>> personList;
    ListView list;
    private static final String TAG_NAME = "name";
    private static final String TAG_EFFECT ="effect";
    private static final String TAG_MADEBY ="madeby";
    private static final String TAG_NOTICE ="notice";

    SQLiteDatabase sampleDB = null;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_main);

        Intent db_intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        int CChecked[] = db_intent.getIntArrayExtra("CCheck");

        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String, String>>();

        try {


            sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            //테이블이 존재하지 않으면 새로 생성합니다.
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (name VARCHAR(9999), effect VARCHAR(9999), madeby VARCHAR(9999), notice VARCHAR(9999) );");

            //테이블이 존재하는 경우 기존 데이터를 지우기 위해서 사용합니다.
            sampleDB.execSQL("DELETE FROM " + tableName  );

            //새로운 데이터를 테이블에 집어넣습니다..
            for (int i=0; i<names.length; i++ ) {
                sampleDB.execSQL("INSERT INTO " + tableName
                        + " (name, effect, madeby, notice)  Values ('" + names[i] + "', '" + effects[i]+"', '" + madeby[i] + "', '" + notice[i] + "');");
            }

            sampleDB.close();

        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("", se.getMessage());


        }

        showList();
    }

    protected void showList(){

        try {

            SQLiteDatabase ReadDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);


            //SELECT문을 사용하여 테이블에 있는 데이터를 가져옵니다..
            Cursor c = ReadDB.rawQuery("SELECT * FROM " + tableName + " ORDER BY RANDOM() LIMIT 3", null);

            if (c != null) {


                if (c.moveToFirst()) {
                    do {

                        //테이블에서 두개의 컬럼값을 가져와서
                        @SuppressLint("Range") String Name = c.getString(c.getColumnIndex("name"));
                        @SuppressLint("Range") String Madeby = c.getString(c.getColumnIndex("madeby"));
                        @SuppressLint("Range") String Effect = c.getString(c.getColumnIndex("effect"));
                        @SuppressLint("Range") String Notice = c.getString(c.getColumnIndex("notice"));

                        //HashMap에 넣습니다.
                        HashMap<String,String> persons = new HashMap<String,String>();

                        persons.put(TAG_NAME,Name);
                        persons.put(TAG_MADEBY,Madeby);
                        persons.put(TAG_EFFECT, Effect);
                        persons.put(TAG_NOTICE,Notice);

                        //ArrayList에 추가합니다..
                        personList.add(persons);

                    } while (c.moveToNext());
                }
            }

            ReadDB.close();


            //새로운 apapter를 생성하여 데이터를 넣은 후..
            adapter = new SimpleAdapter(
                    this, personList, R.layout.list_item,
                    new String[]{TAG_NAME,TAG_MADEBY, TAG_EFFECT, TAG_NOTICE},
                    new int[]{ R.id.name, R.id.madeby, R.id.effect, R.id.notice}
            );


            //화면에 보여주기 위해 Listview에 연결합니다.
            list.setAdapter(adapter);


        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",  se.getMessage());
        }

    }


}
