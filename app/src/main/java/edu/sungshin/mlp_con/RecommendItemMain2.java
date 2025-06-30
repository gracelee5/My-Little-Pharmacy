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

public class RecommendItemMain2 extends Activity{
    private final String dbName = "SWMPDB2";
    private final String tableName = "SWMPTable2222";

    private String names[];
    {
        names = new String[]{
                "간 건강",
                "간 건강 더블 액티브",
                "간 건강 리버",
                "간건강엔곰피로",
                "간메이트",
                "간건강온",
                "간 건강 솔루션",
                "간 건강 솔루션 밀크씨슬",
                "간 건강 올케어 밀크씨슬",
                "간 건강 할-때",
                "간 솔루션",
                "간 편한 인생",
                "간건강 내몸애 밸런스",
                "간(肝) 건강에 도움을 줄 수 있는 헤파락",
                "간(肝)튼튼 곰피로"
        };
    }

    private String madeby[];
    {
        madeby = new String[]{
                "(주)안국건강",
                "(주)비오팜",
                "(주)태극제약",
                "(주)네추럴웨이",
                "(주)콜마비앤에이치 음성공장",
                "(주)한국인삼공사",
                "(주)노비스바이오",
                "(주)알피바이오",
                "(주)비엘헬스케어 2공장",
                "(주)노바렉스",
                "(주)서흥",
                "(주)유니쎌팜",
                "(주)허브큐어",
                "(주)풀무원건강생활",
                "(주)네추럴웨이"
        };
    }

    private String effects[];
    {
        effects = new String[]{
                "<효과>\n[밀크씨슬(카르두스 마리아누스) 추출물 제품] 간 건강에 도움을 줄 수 있음 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요 \n[비타민 E] 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n[밀크씨슬 추출물] 간 건강에 도움을 줄 수 있음 \n[비타민 B1]  탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[홍경천 추출물] 스트레스로 인한 피로 개선에 도움을 줄 수 있음",
                "<효과>\n[밀크씨슬(카르두스 마리아누스) 추출물] 간 건강에 도움을 줄 수 있음 \n[나이아신] 체내 에너지 생성에 필요 \n[셀레늄] 유해산소로부터 세포를 보호하는데 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[아연] \n① 정상적인 면역기능에 필요 ②정상적인 세포분열에 필요 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[비타민 B6]\n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n[곰피 추출물] 간 건강에 도움을 줄 수 있음 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민B6] ① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[나이아신] 체내 에너지 생성에 필요 \n[비타민 B2] 체내 에너지 생성에 필요",
                "<효과>\n[밀크씨슬(카르두스 마리아누스) 추출물] 간 건강에 도움을 줄 수 있음 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[비타민 B6] 단백질 및 아미노산 이용에 필요, 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[비타민 C] \n① 결합조직 형성과 기능유지에 필요 ② 철의 흡수에 필요, 항산화 작용을 하여 ③ 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n[유산균 발효 마늘 추출물] 간건강에 도움을 줄 수 있음 \n[홍경천 추출물] 스트레스로 인한 피로 개선에 도움을 줄 수 있음 \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요 \n① 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n① 탄수화물과 에너지 대사에 필요 \n① 체내 에너지 생성에 필요 \n① 세포와 혈액생성에 필요 ② 태아 신경관의 정상 발달에 필요 ③ 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n[밀크 씨슬] 간 건강에 도움을 줄 수 있음 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[비타민 B6] ① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[나이아신] 체내 에너지 생성에 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[엽산] \n① 세포와 혈액생성에 필요 ② 태아 신경관의 정상 발달에 필요 ③ 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[비오틴] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[셀레늄(또는 셀렌)] 유해산소로부터 세포를 보호하는데 필요 \n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요",
                "<효과>\n[밀크씨슬 추출물] 간 건강에 도움을 줄 수 있음 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[나이아신] 체내 에너지 생성에 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[비타민 E] 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[셀렌] 유해산소로부터 세포를 보호하는데 필요\n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요",
                "<효과>\n[밀크씨슬(카르두스 마리아누스) 추출물] 간 건강에 도움을 줄 수 있음 \n[셀레늄(또는 셀렌)] 유해산소로부터 세포를 보호하는데 필요 \n[나이아신] 체내 에너지 생성에 필요 \n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[엽산] \n① 세포와 혈액생성에 필요 ② 태아 신경관의 정상 발달에 필요 ③ 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n간 건강에 도움을 줄 수 있음",
                "<효과>\n[유산균 발효 마늘 추출물] 간 건강에 도움을 줄 수 있음(생리활성기능 2등급) \n[비타민C] \n① 결합조직 형성과 기능유지에 필요 ② 철의 흡수에 필요 ③ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[셀렌] 유해산소로부터 세포를 보호하는데 필요 \n[비타민 E] 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[아연] \n①정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요 \n[망간] \n① 뼈 형성에 필요 ② 에너지 이용에 필요 ③ 유해산소로부터 세포를 보호하는데 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B2] 체내 에너지 생성에 필요 \n[엽산] \n① 세포와 혈액생성에 필요 ② 태아 신경관의 정상 발달에 필요 ③ 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n[밀크씨슬 추출물] 간 건강에 도움을 줄 수 있음 \n[홍경천추출물] 스트레스로 인한 피로 개선에 도움을 줄 수 있음 \n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요 \n[비타민C] \n① 결합조직 형성과 기능유지에 필요 ② 철의 흡수에 필요 ③ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[비타민 B1] 탄수화물과 에너지 대사에 필요 \n[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n간 건강에 도움을 줄 수 있음",
                "<효과>\n간 건강에 도움을 줄 수 있음",
                "<효과>\n간 건강에 도움을 줄 수 있음 \n①탄수화물과 에너지 대사에 필요 \n②단백질 및 아미노산 이용에 필요 \n③혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n④지방, 탄수화물, 단백질 대사와 에너지 생성에 필요"
        };
    }

    private String notice[];
    {
        notice = new String[]{
                "<주의사항>\n① 어린이의 경우 섭취 시 목에 걸릴 우려가 있으니 보호자의 지도하에 섭취하십시오. \n② 특이체질, 알레르기 체질의 경우 성분을 확인하시고 섭취하여 주시기 바랍니다.\n③ 알레르기 반응이 나타나는 경우에는 섭취 중단\n④ 설사, 위통, 복부팽만 등의 위장관계 장애 나타나는 경우에는 섭취에 주의",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단\n② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의\n③ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 어린이, 임산부 및 수유부는 섭취를 피하십시오.\n② 알레르기 반응이 나타나는 경우에는 섭취를 중단하십시오.\n③ 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의하십시오.\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.",
                "<주의사항>\n① 임산부, 수유부 및 12세 이하 어린이는 섭취 시 주의\n② 요오드 함량이 높은 식품(해조류, 어패류 등)과 병용 섭취 시 주의\n③ 갑상선질환 등을 보유하고 있는 사람은 섭취 시 주의\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 특이체질, 알레르기 체질의 경우에는 간혹 개인에 따라 과민반응을 나타낼 수 있으므로 원료를 확인한 후 섭취하십시오.\n② 유통기한이 경과된 제품은 섭취하지 마십시오.\n③ 알레르기 반응이 나타나는 경우에는 섭취 중단\n④ 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의\n⑤ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단하십시오. ② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의하십시오.",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단하십시오. ② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의하십시오.",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단\n② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의\n③ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 알레르기 체질이신 경우 성분을 확인한 후 섭취여부를 결정하여야 함\n② 알레르기 반응이 나타나는 경우에는 섭취 중단\n③ 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 특정질환, 특이체질, 알레르기체질, 임산부의 경우에는 간혹 개인에 따라 과민반응이 나타날 수 있으므로 원료를 확인하시고, 섭취전에 전문가와 상담하시기 바랍니다.\n② 어린이, 임산부 및 수유부는 섭취를 피할 것\n③ 알레르기 반응이 나타나는 경우에는 섭취 중단\n④ 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의\n⑤ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n② 섭취방법 및 섭취량을 준수할 것\n③ 임산부, 수유여성, 어린이, 질병치료 중인 분은 섭취 전 의사와 상담 후 섭취할 것\n④ 특정 성분에 알레르기가 있으신 분은 원료명을 확인 후 섭취할 것    \n⑤ 개봉 또는 섭취 시 포장재에 의해 상처를 입을 수 있으니 주의할 것",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단\n② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단 \n② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의",
                "<주의사항>\n① 알레르기 체질이신 경우 성분을 확인하신 후 섭취하십시오\n② 의약품 복용시 섭취에 주의하십시오",
                "<주의사항>\n① 임산부, 수유부 및 12세 이하 어린이는 섭취 시 주의\n② 요오드 함량이 높은 식품(해조류, 어패류 등)과 병용 섭취 시 주의\n③ 갑상선질환 등을 보유하고 있는 사람은 섭취 시 주의"
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
                    new String[]{TAG_NAME, TAG_MADEBY, TAG_EFFECT, TAG_NOTICE},
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
