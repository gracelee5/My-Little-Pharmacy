package edu.sungshin.mlp_con;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class RecommendItemMain4 extends Activity{
    private final String dbName = "SWMPDB4";
    private final String tableName = "SWMPTable44444";

    private String names[];
    {
        names = new String[]{
                "뼈 & 치아 솔루션",
                "뼈 건강 비타민D 마그네슘",
                "뼈 건강엔 녹우칼슘캡슐",
                "뼈 건강엔 비타민D 2000IU",
                "뼈 건강이 필요한 나에겐 칼슘",
                "뼈건강엔녹우칼슘정제",
                "뼈·신경·근육엔 칼슘마그네슘",
                "뼈가 더 칼슘",
                "뼈가더에스칼슘",
                "뼈가더칼슘엔큐",
                "뼈건강337본",
                "뼈가튼튼 밀키튼+ PLUS",
                "뼈가튼튼 칼슘젤리",
                "뼈건강 본",
                "뼈건강 비타민D"
        };
    }

    private String madeby[];
    {
        madeby = new String[]{
                "(주)서흥",
                "(주)태극제약",
                "(주)다스코바이오",
                "(주)콜마비앤에이치 음성공장",
                "(주)유유헬스케어",
                "(주)다스코바이오",
                "(주)한풍네이처팜",
                "(주)케이지랩 주식회사",
                "(주)동서바이오팜",
                "(주)동서바이오팜",
                "(주)한국씨엔에스팜",
                "(주)서흥헬스케어",
                "(주)알피바이오",
                "(주)풍기인삼농협",
                "(주)코스맥스엔비티"
        };
    }

    private String effects[];
    {
        effects = new String[]{
                "<효과>\n[칼슘] \n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[마그네슘] \n①에너지 이용에 필요②신경과 근육 기능 유지에 필요 \n[망간] \n①뼈 형성에 필요②에너지 이용에 필요③유해산소로부터 세포를 보호하는데 필요 \n[비타민 D] \n①칼슘과 인이 흡수되고 이용되는데 필요②뼈의 형성과 유지에 필요③골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌 \n[마그네슘] \n① 에너지 이용에 필요 \n② 신경과 근육 기능 유지에 필요",
                "<효과>\n[칼슘] \n① 뼈와 치아형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험감소에 도움을 줌 \n[마그네슘] \n① 에너지 이용에 필요 ② 신경과 근육 기능 유지에 필요 \n[아연] \n①정상적인 면역기능에 필요 ②정상적인 세포분열에 필요 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈 의 형성과 유지에 필요 \n③ 골다공증발생 위험감소에 도움을 줌",
                "<효과>\n[비타민 D] ① 칼슘과 인이 흡수되고 이용되는데 필요, 뼈의 형성과 유지에 필요 ② 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n[칼슘] \n① 뼈와 치아형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험감소에 도움을 줌 \n[마그네슘] \n①에너지 이용에 필요 ② 신경과 근육 기능 유지에 필요 \n[아연] \n①정상적인 면역기능에 필요 ②정상적인 세포분열에 필요 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험감소에 도움을 줌",
                "<효과>\n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n ② 뼈의 형성과 유지에 필요 \n ③ 골다공증발생 위험 감소에 도움을 줌 \n[칼슘] \n① 뼈와 치아 형성에 필요 \n ②신경과 근육 기능 유지에 필요 \n ③정상적인 혈액응고에 필요 \n ④ 골다공증발생 위험 감소에 도움을 줌 \n[마그네슘] \n① 에너지 이용에 필요 ② 신경과 근육 기능 유지에 필요",
                "<효과>\n[칼슘] \n①뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n[칼슘] \n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[마그네슘] \n①에너지 이용에 필요 ②신경과 근육 기능 유지에 필요 \n[아연] \n① 정상적인 면역기능에 필요 \n② 정상적인 세포분열에 필요 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n[칼슘] \n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[마그네슘] \n① 에너지 이용에 필요 \n② 신경과 근육 기능 유지에 필요 \n[아연] \n① 정상적인 면역기능에 필요 \n② 정상적인 세포분열에 필요 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌 \n[비타민 K] \n① 정상적인 혈액응고에 필요 \n② 뼈의 구성에 필요 \n[칼슘] \n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[가시오가피숙지황복합추출물] 뼈건강에 도움을 줄 수 있음",
                "<효과>\n[칼슘] \n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[폴리감마글루탐산] 체내 칼슘흡수 촉진에 도움을 줄 수 있음 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌 \n[비타민 K] \n① 정상적인 혈액응고에 필요 \n② 뼈의 구성에 필요",
                "<효과>\n[칼슘] \n① 뼈와 치아 형성에 필요 \n② 신경과 근육 기능 유지에 필요 \n③ 정상적인 혈액응고에 필요 \n④ 골다공증발생 위험 감소에 도움을 줌 \n[망간] \n① 뼈 형성에 필요 \n② 에너지 이용에 필요 \n③ 유해산소로부터 세포를 보호하는데 필요 \n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n면역력 증진･피로개선･뼈 건강에 도움을 줄 수 있음",
                "<효과>\n[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌"
        };
    }

    private String notice[];
    {
        notice = new String[]{
                "<주의사항>\n①고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n②이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n③ 임산부, 수유여성 및 어린이는 섭취에 주의\n④ 특정 성분에 알레르기가 있으신 분은 원료명을 확인 후 섭취하십시오.",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 섭취량 및 섭취방법을 확인한 후 섭취하시고 섭취 시 캡슐이 기도에 걸릴 수 있으니 주의 하십시오. \n② 이상 증상이 생길 경우 섭취를 중단하시고, 전문의와 상담하시거나 소비자상담실로 문의하시기 바랍니다.",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담하십시오.\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.\n③ 유통기한이 경과된 제품은 섭취하지 마십시오.\n④ 특이체질, 알레르기 체질의 경우에는 간혹 개인에 따라 과민반응을 나타낼 수 있으므로 원료를 확인한 후 섭취하십시오.",
                "<주의사항>\n① 질환보유자 또는 약물 복용 중이신 분은 섭취 전에 의사, 약사 등 전문가와 상의하십시오.\n②알레르기 체질이신 분은 성분을 확인한 후 섭취하시기 바랍니다.",
                "<주의사항>\n① 섭취량 및 섭취방법을 확인한 후 섭취하시고 섭취 시 캡슐이 기도에 걸릴 수 있으니 주의 하십시오.\n② 이상 증상이 생길 경우 섭취를 중단하시고, 전문의와 상담하시거나 소비자상담실로 문의하시기 바랍니다.",
                "<주의사항>\n① 특이체질, 알레르기 체질의 경우에는 간혹 개인에 따라 과민반응을 나타낼 수 있으므로 원료를 확인한 후 섭취하십시오.\n② 유통기한을 확인하시기 바라며, 섭취량 및 섭취방법을 준수하시기 바랍니다.\n③ 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담하시기 바랍니다. \n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담하시기 바랍니다.",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담하십시오.\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담하십시오.\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.",
                "<주의사항>\n① 어린이의 경우 섭취 시 목에 걸릴 우려가 있으니 보호자의 지도하에 섭취하십시오.\n② 특이체질, 알레르기 체질의 경우 성분을 확인하시고 섭취하여 주시기 바랍니다. \n③ 영·유아, 임산부, 수유부는 섭취에 주의\n④ 알레르기 체질이거나 특정질환이 있는 사람은 섭취에 주의",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n③ 항응고제 등 복용 시 전문가와 상담할 것",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의",
                "<주의사항>\n① 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담하여 주십시오.\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담하여 주십시오.\n③ 특이체질, 알레르기체질, 임산부 및 수유부의 경우에는 의사와 상담 후 섭취여부를 결정하십시오.\n④ 섭취량 및 섭취방법, 유통기한을 을 확인한 후 섭취하십시오.",
        };
    }

    ArrayList<HashMap<String, String>> personList;
    ListView list;
    private static final String TAG_NAME = "name";
    private static final String TAG_EFFECT ="effect";
    private static final String TAG_MADEBY = "madeby";
    private static final String TAG_NOTICE = "notice";

    SQLiteDatabase sampleDB = null;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_main);

        //Intent db_intent = getIntent(); //전달할 데이터를 받을 Intent
        ///text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        //int CChecked[] = db_intent.getIntArrayExtra("CCheck");

        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String, String>>();

        try {


            sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            //테이블이 존재하지 않으면 새로 생성합니다.
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (name VARCHAR(9999), effect VARCHAR(9999), madeby VARCHAR(9999), notice VHARCHAR(9999) );");

            //테이블이 존재하는 경우 기존 데이터를 지우기 위해서 사용합니다.
            sampleDB.execSQL("DELETE FROM " + tableName  );

            //새로운 데이터를 테이블에 집어넣습니다..
            for (int i=0; i<names.length; i++ ) {
                sampleDB.execSQL("INSERT INTO " + tableName
                        + " (name, effect, madeby, notice)  Values ('" + names[i] + "', '" + effects[i]+"', '" + madeby[i]+"', '" + notice[i] + "');");
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
                        persons.put(TAG_MADEBY, Madeby);
                        persons.put(TAG_EFFECT, Effect);
                        persons.put(TAG_NOTICE, Notice);

                        //ArrayList에 추가합니다..
                        personList.add(persons);

                    } while (c.moveToNext());
                }
            }

            ReadDB.close();


            //새로운 apapter를 생성하여 데이터를 넣은 후..
            adapter = new SimpleAdapter(
                    this, personList, R.layout.list_item,
                    new String[]{TAG_NAME, TAG_MADEBY ,TAG_EFFECT, TAG_NOTICE},
                    new int[]{ R.id.name, R.id.madeby ,R.id.effect, R.id.notice}
            );


            //화면에 보여주기 위해 Listview에 연결합니다.
            list.setAdapter(adapter);


        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",  se.getMessage());
        }

    }

}
