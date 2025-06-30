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

public class RecommendItemMain7 extends Activity {
    private final String dbName = "SWMPDB7";
    private final String tableName7 = "SWMPTABLE77777";

    private String names7[];
    {
        names7 = new String[]{
                "걱정말랑",
                "굿나잇비타4",
                "광동지뉴인 휴다이어트",
                "광동 패스신공 기氣",
                "광동 파워테닌",
                "고요하다",
                "고요한 스트레스",
                "고려은단 수면비법",
                "고려기력환",
                "경희홍삼&테아닌 골드스틱",
                "경희 잘테아선테아닌",
                "경희 피로가라",
                "경방 스트레스바이테아닌 타트체리맛",
                "겟스마트나인투식스",
                "건강엔 L-테아닌",
                "굿모닝 스트레스 제로",
                "굿모닝 슬립웰",
                "굿바이스트레스 웰컴다이어트 트리플",
                "그린픽 스트레스 건강"
        };
    }
    private String madeby7[];
    {
        madeby7 = new String[]{
                "(주)코스맥스바이오",
                "(주)엠에스바이오텍",
                "(주)노바렉스",
                "(주)한국씨엔에스팜",
                "(주)팜텍코리아",
                "(주)비엘헬스케어 2공장",
                "(주)한국씨엔에스팜",
                "(주)비엘헬스케어 2공장",
                "농업회사법인(주)개성상인-제2공장",
                "(주)대동고려삼",
                "(주)세종바이오팜",
                "(주)세종바이오팜",
                "(주)경방신약 금산공장",
                "(주)코스맥스바이오",
                "(주)비오팜",
                "(주)월드웨이",
                "(주)허브큐어",
                "(주)콜마비앤에이치 음성공장",
                "(주)비엘헬스케어 2공장"
        };
    }

    private String effects7[];
    {
        effects7 = new String[]{
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음.",
                "<효과>\n① 스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 유해산소로부터 세포를 보호하는데 필요\n" +
                        "탄수화물과 에너지 대사에 필요\n" +
                        "① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "지방, 탄수화물, 단백질 대사와 에너지 생성에 필요",
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "체지방 감소에 도움을 줄 수 있음",
                "<효과>\n[테아닌] 스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "[비타민 C] \n① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 항산화 작용을 하여 유해산소로부터 세포를 보호하는데 필요\n" +
                        "[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요\n" +
                        "[마그네슘] ① 에너지 이용에 필요 ② 신경과 근육 기능 유지에 필요\n" +
                        "[아연] ① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요",
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "체내 에너지 생성에 필요",
                "<효과>\n[테아닌] 스트레스로 인한 긴장완화에 도움을 줄 수 있음",
                "<효과>\n[테아닌] 스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "[비타민 B1] 탄수화물과 에너지 대사에 필요\n" +
                        "[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌\n" +
                        "[아연] ① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요",
                "<효과>\n[감태추출물] 수면의 질 개선에 도움을 줄 수 있음(생리활성기능 2등급)\n" +
                        "[홍경천추출물] 스트레스로 인한 피로 개선에 도움을 줄 수 있음\n" +
                        "[비타민 C] \n① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 유해산소로부터 세포를 보호하는데 필요\n" +
                        "[나이아신] 체내 에너지 생성에 필요\n" +
                        "[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요\n" +
                        "[비타민 B6] \n① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "[비타민 B2] 체내 에너지 생성에 필요\n" +
                        "[엽산] \n① 세포와 혈액생성에 필요 \n② 태아 신경관의 정상 발달에 필요 \n③ 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음",
                "<효과>\n면역력 증진·피로개선·혈소판 응집억제를 통한 혈액흐름·기억력 개선·항산화에 도움을 줄 수 있음\n" +
                        "스트레스로 인한 긴장완화에 도움을 줄 수 있음",
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "① 에너지 이용에 필요 ② 신경과 근육 기능 유지에 필요\n" +
                        "① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "지방, 탄수화물, 단백질 대사와 에너지 생성에 필요\n" +
                        "① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요",
                "<효과>\n스트레스로 인한 피로 개선에 도움을 줄 수 있음\n" +
                        "스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "체내 에너지 생성에 필요\n" +
                        "지방, 탄수화물, 단백질 대사와 에너지 생성에 필요\n" +
                        "탄수화물과 에너지 대사에 필요\n" +
                        "체내 에너지 생성에 필요\n" +
                        "① 단백질 및 아미노산 이용에 필요 ② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요",
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음",
                "<효과>\n[홍경천추출물] 스트레스로 인한 피로 개선에 도움을 줄 수 있음 \n" +
                        "[은행잎추출물] 기억력개선 · 혈행 개선에 도움을 줄 수 있음 \n" +
                        "[마리골드꽃추출물] 노화로 인해 감소될 수 있는 황반색소밀도를 유지시켜 주어 눈 건강에 도움을 줌\n" +
                        "[비타민 B1] 탄수화물과 에너지 대사에 필요\n" +
                        "[비타민 B2] 체내 에너지 생성에 필요\n" +
                        "[비타민 B12] 정상적인 엽산 대사에 필요",
                "<효과>\n[아연] ① 정상적인 면역기능에 필요 ② 정상적인 세포분열에 필요\n" +
                        "[비타민B6] \n① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "[테아닌] 스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "[비타민 B1] 탄수화물과 에너지 대사에 필요\n" +
                        "[비타민 D] \n① 칼슘과 인이 흡수되고 이용되는데 필요 \n② 뼈의 형성과 유지에 필요 \n③ 골다공증발생 위험 감소에 도움을 줌",
                "<효과>\n스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "① 단백질 및 아미노산 이용에 필요 \n② 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "지방, 탄수화물, 단백질 대사와 에너지 생성에 필요\n" +
                        "① 결합조직 형성과 기능유지에 필요 \n② 철의 흡수에 필요 \n③ 유해산소로부터 세포를 보호하는데 필요",
                "<효과>\n스트레스로 인한 피로개선에 도움을 줄 수 있음 \n[감태추출물(개별인정형원료 제2015-6호)] 수면의 질 개선에 도움을 줄 수 있음",
                "<효과>\n[테아닌]　스트레스로 인한 긴장완화에 도움을 줄 수 있음\n" +
                        "[홍경천 추출물] 스트레스로 인한 피로 개선에 도움을 줄 수 있음\n" +
                        "[콜레우스포스콜리] 체지방 감소에 도움을 줄 수 있음\n" +
                        "[비타민 B1] 탄수화물과 에너지 대사에 필요\n" +
                        "[비타민 B2] 체내 에너지 생성에 필요\n" +
                        "[비타민 B6] 단백질 및 아미노산 이용에 필요, 혈액의 호모시스테인 수준을 정상으로 유지하는데 필요\n" +
                        "[판토텐산] 지방, 탄수화물, 단백질 대사와 에너지 생성에 필요",
                "<효과>\n[테아닌] 스트레스로 인한 긴장완화에 도움을 줄 수 있음"
        };
    }

    private String notice[];
    {
        notice = new String[]{
                "<주의사항>\n① 섭취 시 위장장애, 소화불량의 증상이 있을 경우 섭취를 중단하십시오. \n② 개인의 신체 상태에 따라 이상 증상이 생길 경우 섭취를 중단하십시오.  \n③ 섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오. \n④ 특정 원료 성분에 알레르기 체질은 원료 성분을 확인 후 섭취 하십시오. \n⑤ 제품 개봉 시 포장재에 의해 상처를 입을 위험이 있고, 개봉 시 내용물이 흘러나올 수 있으므로 취급 시 주의하십시오.\n⑥ 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의하십시오.\n⑦ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의하십시오.",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의 \n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 특정질환, 특이체질, 알레르기체질, 소화불량, 두드러기, 임산부의 경우에는 간혹 개인에 따라 과민반응이 나타날 수 있으므로 원료를 확인하시고, 섭취 전에 전문가와 상담하시기 바랍니다.\n② 이상사례 발생 시 섭취를 중단하고 전문가와 상담하십시오.\n③ 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n④ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의\n⑤ 석류에 알레르기가 있는 사람은 섭취에 주의\n⑥ 에스트로겐 호르몬에 민감한 사람은 섭취에 주의",
                "<주의사항>\n① 유통기한을 확인하시기 바라며, 섭취량 및 섭취방법을 준수하시기 바랍니다.\n② 특이체질, 알레르기 체질이신 분은 원재료를 확인하신 후 섭취하십시오.\n③ 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의하시기 바랍니다.\n④ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의하시기 바랍니다.\n⑤ 이상사례 발생 시 섭취를 중단하고 전문가와 상담하시기 바랍니다.",
                "<주의사항>\n① 특이체질, 알레르기 체질인 경우는 간혹 개인에 따라 과민반응이 나타낼 수 있으므로  원료를 확인 후 섭취\n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의\n③ 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의",
                "<주의사항>\n① 알레르기 체질이신 경우 성분을 확인한 후 섭취여부를 결정하여야 함\n② 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n③ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의 \n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의\n③ 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것 \n④ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n⑤ 유통기한을 확인하시기 바라며, 섭취량 및 섭취 방법을 준수하시기 바랍니다.\n⑥ 특이체질, 알레르기 체질의 경우 성분을 확인하시고 섭취하여 주시기 바랍니다.",
                "<주의사항>\n① 알레르기 체질이신 경우 성분을 확인 한 후 섭취여부를 결정하여야 함.\n② 요오드 함량이 높은 식품(해조류, 어패류 등) 섭취 시 주의\n③ 갑상선 질환, 위장관 질환 또는 위장관 장애 등을 보유하고 있는 사람은 섭취 시 주의 \n④ 임산부, 수유부 및 12세 이하 어린이는 섭취 시 주의",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 의약품(당뇨치료제, 혈액항응고제) 복용 시 섭취에 주의\n② 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n③ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 알레르기 반응이 나타나는 경우에는 섭취 중단하십시오.\n② 설사, 위통, 복부팽만 등의 위장관계 장애가 나타나는 경우에는 섭취에 주의하십시오.",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의",
                "<주의사항>\n① 섭취 시 목에 걸릴 수 있으므로 반드시 물과 함께 섭취하십시오. \n② 섭취 시 위장장애, 소화불량의 증상이 있을 경우 섭취를 중단하십시오.\n③ 개인의 신체 상태에 따라 이상 증상이 생길 경우 섭취를 중단하십시오.\n④ 섭취 전 제품에 이상이 있는 경우 섭취를 금하십시오.\n⑤ 특정 원료 성분에 알레르기 체질은 원료 성분을 확인 후 섭취하십시오.  \n⑥ 과다 섭취 시 일시적으로 피부가 황색으로 변할 수 있습니다.\n⑦ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의하십시오.\n⑧ 의약품(항응고제) 복용 시 섭취에 주의하십시오.",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의\n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의\n③ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것\n④ 고칼슘혈증이 있거나 의약품 복용 시 전문가와 상담할 것\n⑤ 이상사례 발생 시 섭취를 중단하고 전문가와 상담할 것",
                "<주의사항>\n① 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의하십시오.\n② 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의하십시오.",
                "<주의사항>\n① 개인의 신체 상태에 따라 이상 증상이 생길 경우 섭취를 중단하십시오. \n② 특정 원료 성분에 알레르기 체질은 원료 성분을 확인 후 섭취하십시오.\n③ 제품 개봉시 포장재에 의해 상처를 입을 수 있으니 주의하십시오.\n④ 요오드 함량이 높은 식품(해조류,어패류 등) 섭취 시 주의 하십시오.\n⑤ 갑상선질환, 위장관 질환 또는 위장관 장애 등을 보유 하고 있는 사람을 섭취 시 주의하십시오.\n⑥ 임산부, 수유부 및 12세 이하 어린이는 섭취 시 주의하십시오.",
                "<주의사항>\n① 특이체질, 알레르기 체질의 경우에는 간혹 개인에 따라 과민반응을 나타낼 수 있으므로 원료를 확인한 후 섭취하십시오. \n② 유통기한이 경과된 제품은 섭취하지 마십시오. 용기안의 방습제는 섭취하지 마십시오. \n③ 원료의 특성상 약간의 색상변화가 있거나 손에 묻어날 수 있으나 품질에는 이상이 없으므로 안심하고 섭취하십시오. \n④ 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의.\n⑤ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의.",
                "<주의사항>\n① 알레르기 체질이신 경우 성분을 확인한 후 섭취여부를 결정하여야 함.\n② 카페인 함유음료(커피, 홍차, 녹차 등)와의 병용 섭취에 주의 \n③ 임산부, 수유부, 어린이 및 수술전후 환자는 섭취에 주의"
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

        Log.i(String.valueOf(names7.length),"확인");
        Log.i(String.valueOf(madeby7.length),"확인");
        Log.i(String.valueOf(effects7.length),"확인");

        try {


            sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            //테이블이 존재하지 않으면 새로 생성합니다.
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName7
                    + " (name VARCHAR(9999), effect VARCHAR(9999), madeby VARCHAR(9999), notice VARCHAR(9999) );");

            //테이블이 존재하는 경우 기존 데이터를 지우기 위해서 사용합니다.
            sampleDB.execSQL("DELETE FROM " + tableName7  );

            //새로운 데이터를 테이블에 집어넣습니다..
            for (int i=0; i<names7.length; i++ ) {
                sampleDB.execSQL("INSERT INTO " + tableName7
                        + " (name, effect, madeby, notice)  Values ('" + names7[i] + "', '" + effects7[i] + "', '" + madeby7[i]+"', '" + notice[i]+"');");
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
            Cursor c = ReadDB.rawQuery("SELECT * FROM " + tableName7 + " ORDER BY RANDOM() LIMIT 3", null);

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
