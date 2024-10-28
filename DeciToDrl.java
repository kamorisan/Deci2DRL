package <格納したフォルダに合わせて修正>;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;

/**
 * DecisionTable(Excel)をDRLへ変換するサンプル
 * このクラスはルールエンジンが内部的に行っている変換と同じ処理をして、DecisionTableから生成されるDRLを確認するための物です。
 * DecisionTableのビルドでエラーが出た際には、変換されたDRLを確認することでエラーの行番号が分かり、エラーの内容が理解しやすくなります。
 */

public class DeciToDrl {

    public static void main(String[] args) throws Exception {

        String fullPath = "rules/sample.xlsx"; //DRLに変換したいファイルパスを入力する

        System.out.println("=== デシジョンテーブルから生成される DRL ===");
        KieServices kieServices = KieServices.Factory.get();
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl;
        drl = compiler.compile(kieServices.getResources().newFileSystemResource(fullPath, "UTF-8").getInputStream(), InputType.XLS);
        System.out.println(drl);
        System.out.println("======================================");
    }
}
