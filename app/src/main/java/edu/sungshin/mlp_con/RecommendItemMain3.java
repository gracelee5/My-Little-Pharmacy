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

public class RecommendItemMain3 extends Activity {
    private final String dbName = "SWMPDB3";
    private final String tableName = "SWMPTable3333";

    private String names[];
    {
        names = new String[]{
                "눈건강엔 비건 루테인",
                "눈건강엔 닥터루테인",
                "눈건강엔 루테인",
                "눈건강온",
                "눈건강을돌려다오",
                "눈건강촉촉플러스",
                "루테인 맥스",
                "루테인 멀티비타민미네랄",
                "눈과 혈행에 이롭 초임계 rTG 오메가3 루테인 지아잔틴",
                "눈과 활력에 좋은 루테인 비콤",
                "눈사랑 골드포르테",
                "눈눈",
                "눈메이트",
                "눈박사루테인",
                "눈부신 날"
        };
    }

    private String madeby[];
    {
        madeby  = new String[]{
                "(주)코스맥스바이오",
                "(주)세종바이오팜",
                "(주)네오크레마 익산공장",
                "(주)한국인삼공사",
                "(주)한미양행",
                "(주)한미양행",
                "(주)유니쎌팜",
                "(주)비엘헬스케어 2공장",
                "(주)노바렉스2공장",
                "(주)안국건강",
                "(주)중원바이오팜",
                "(주)뉴팜",
                "(주)콜마비앤에이치 음성공장",
                "(주)극동에치팜 2공장",
                "(주)한미양행"
        };
    }

    private String effects[];
    {
        effects = new String[]{
                "<효과>\n노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음",
                "<효과>\n[마리골드꽃 추출물] 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음 \n[아연] \n① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요 \n[비타민 E] 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[비타민 A] \n① 어두운 곳에서 시각 적응을 위해 필요 ② 피부와 점막을 형성하고 기능을 유지하는데 필요 ③ 상피세포의 성장과 발달에 필요",
                "<효과>\n노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음",
                "<효과>\n① 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음 \n② 혈중 중성지질 개선·혈행 개선·건조한 눈을 개선하여 눈 건강에 도움을 줄 수 있음 \n③눈의 피로도 개선에 도움을 줄 수 있음",
                "<효과>\n① 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음 \n② 체내 에너지 생성에 필요 \n③ 정상적인 면역기능에 필요 \n④ 정상적인 세포분열에 필요 \n⑤ 어두운 곳에서 시각 적응을 위해 필요 \n⑥ 피부와 점막을 형성하고 기능을 유지하는데 필요 \n⑦ 상피세포의 성장과 발달에 필요",
                "<효과>\n① 어두운 곳에서 시각 적응을 위해 필요 \n② 피부와 점막을 형성하고 기능을 유지하는데 필요 \n③ 상피세포의 성장과 발달에 필요 \n④ 혈중 중성지질 개선·혈행 개선·건조한 눈을 개선하여 눈 건강에 도움을 줄 수 있음 \n⑤ 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줌",
                "<효과>\n① 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음 \n② 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n③ 어두운 곳에서 시각 적응을 위해 필요",
                "<효과>\n[마리골드꽃 추출물] 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음 \n[비타민E] 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요 \n[나이아신] 체내 에너지 생성에 필요 \n[아연] \n① 정상적인 면역기능에 필요 \n② 정상적인 세포분열에 필요 \n[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요 \n[셀렌] 유해산소로부터 세포를 보호하는데 필요 \n[비타민B12] 정상적인 엽산 대사에 필요 \n[비타민A] \n① 어두운 곳에서 시각 적응을 위해 필요 \n② 피부와 점막을 형성하고 기능을 유지하는데 필요 \n③ 상피세포의 성장과 발달에 필요 \n[비타민B6] \n① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[비타민B1] 탄수화물과 에너지 대사에 필요 \n[비타민B2] 체내 에너지 생성에 필요 \n[엽산] \n① 세포와 혈액생성에 필요 \n② 태아 신경관의 정상 발달에 필요 \n③ 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요 \n[비타민D] \n①칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n① 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈건강에 도움을 줄 수 있음 \n② 혈중 중성지질 개선･혈행 개선에 도움을 줄 수 있음 \n③건조한 눈을 개선하여 눈 건강에 도움을 줄 수 있음 \n④ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줌",
                "<효과>\n①어두운 곳에서 시각 적응을 위해 필요 \n② 피부와 점막을 형성하고 기능을 유지하는데 필요 \n③ 상피세포의 성장과 발달에 필요",
                "<효과>\n[빌베리 추출물] 눈의 피로 개선에 도움을 줄 수 있음",
                "<효과>\n[EPA 및 DHA함유유지] \n① 혈중 중성지질 개선·혈행 개선에 도움을 줄 수 있음 \n②건조한 눈을 개선하여 눈 건강에 도움을 줄 수 있음 \n[마리골드꽃추출물] 노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음 \n헤마토코쿠스 추출물 : 눈의 피로도 개선에 도움을 줄 수 있음",
                "<효과>\n노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줄 수 있음",
                "<효과>\n노화로 인해 감소될 수 있는 황반색소밀도를 유지하여 눈 건강에 도움을 줌"
        };
    }

    private String notice[];
    {
        notice  = new String[]{
                "<주의사항>\n① 섭취 시 목에 걸릴 수 있으므로 반드시 물과 함께 섭취하십시오. \n② 섭취 시 위장장애, 소화불량의 증상이 있을 경우 섭취를 중단하십시오.\n③ 개인의 신체 상태에 따라 이상 증상이 생길 경우 섭취를 중단하십시오.\n④ 섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오.\n⑤ 특정 원료 성분에 알레르기 체질은 원료 성분을 확인 후 섭취하십시오.\n⑥ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있습니다.",
                "<주의사항>\n① 영‧유아, 어린이, 임산부 및 수유부는 섭취를 피할 것\n② 흡연자는 섭취 시 전문가와 상담할 것\n③ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음",
                "<주의사항>\n① 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n② 의약품(항응고제, 항혈소판제, 혈압강하제 등) 복용 시 전문가와 상담할 것\n③ 개인에 따라 피부 관련 이상반응이 발생할 수 있음\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n⑤ β-카로틴의 흡수를 저해할 수 있음",
                "<주의사항>\n① 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n③ 알레르기 체질이신 경우 성분을 확인 한 후 섭취하시기 바랍니다.",
                "<주의사항>\n과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음",
                "<주의사항>\n① 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 영‧유아, 어린이, 임산부 및 수유부는 섭취를 피할 것\n② 흡연자는 섭취 시 전문가와 상담할 것\n③ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음",
                "<주의사항>\n① 특정질환, 특이체질, 알레르기체질, 임산부의 경우에는 간혹 개인에 따라 과민반응이 나타날 수 있으므로 원료를 확인하시고, 섭취전에 전문가와 상담하시기 바랍니다.\n② 영·유아, 어린이, 임산부 및 수유부는 섭취를 피할 것\n③ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n④ 흡연자는 섭취 시 전문가와 상담할 것\n⑤ 의약품(항응고제, 항혈소판제, 혈압강하제 등) 복용 시 전문가와 상담할 것\n⑥ 개인에 따라 피부 관련 이상반응이 발생할 수 있음\n⑦ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n⑧ 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n⑨ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음.",
                "<주의사항>\n① 섭취량 및 섭취방법을 확인하시고 섭취하십시오\n② 유통기간이 경과된 제품은 섭취하지 않도록 주의 바랍니다.\n③ 제품 개봉 또는 섭취시 포장재의 날카로운 부분에 상처를 입을 수 있으니 주의하시기 바랍니다.\n④ 알레르기 체질이신 분은 원료성분을 확인하고 섭취하십시오\n⑤ 임산부, 수유부, 만성질환이나 현재 질병 치료중인 분은 전문의와 상의 후 섭취하십시오",
                "<주의사항>\n① 질환이 있거나 의약품 복용 시 전문가와 상담하십시오.\n② 알레르기 체질 등은 개인에 따라 과민반응을 나타낼 수 있습니다.\n③ 어린이가 함부로 섭취하지 않도록 일일섭취량 방법을 지도하십시오.\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.\n⑤ 섭취량 및 섭취방법을 확인하시고 섭취하여 주십시오.\n⑥ 유통기한이 경과된 제품은 섭취하지 않도록 주의 바랍니다.\n⑦ 제품 개봉 또는 섭취 시 포장재에 의해 상처를 입을 수 있으니 주의하시기 바랍니다.",
                "<주의사항>\n① 특이체질, 알레르기 체질의 경우에는 간혹 개인에 따라 과민반응을 나타낼 수 있으므로 원료를 확인한 후 섭취하십시오.\n② 유통기한이 경과된 제품은 섭취하지 마십시오.\n③ 의약품(항응고제, 항혈소판제, 혈압강하제 등) 복용 시 전문가와 상담할 것\n④ 개인에 따라 피부 관련 이상반응이 발생할 수 있음\n⑤ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n⑥ 과다 섭취시 일시적으로 피부가 황색으로 변할 수 있음\n⑦  β-카로틴의 흡수를 저해할 수 있음",
                "<주의사항>\n① 영‧유아, 어린이, 임산부 및 수유부는 섭취를 피할 것\n② 흡연자는 섭취 시 전문가와 상담할 것\n③ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있음\n② 알레르기 체질이신 경우 성분을 확인 한 후 섭취하시기 바랍니다."
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
                    new String[]{TAG_NAME, TAG_MADEBY ,TAG_EFFECT, TAG_NOTICE},
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