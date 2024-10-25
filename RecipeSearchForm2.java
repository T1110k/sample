import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ArrayList;

public class RecipeSearchForm {
    public static void main(String[] args) {
        // レシピのデータベース作成 (食材に応じたレシピを保持)
        HashMap<String, ArrayList<String>> recipes = new HashMap<>();

        // 各食材に対応するレシピのリスト
        ArrayList<String> appleRecipes = new ArrayList<>();
        appleRecipes.add("アップルパイ: リンゴ、砂糖、バター、小麦粉を使用します。");
        appleRecipes.add("焼きリンゴ: リンゴをオーブンで焼くだけ。");

        ArrayList<String> bananaRecipes = new ArrayList<>();
        bananaRecipes.add("バナナスムージー: バナナ、牛乳、ヨーグルトを混ぜます。");
        bananaRecipes.add("バナナパンケーキ: バナナ、小麦粉、卵を使います。");

        ArrayList<String> chickenRecipes = new ArrayList<>();
        chickenRecipes.add("チキンカレー: 鶏肉、カレーパウダー、野菜を煮込みます。");
        chickenRecipes.add("グリルチキン: 鶏肉に塩、コショウを振り、焼くだけ。");

        ArrayList<String> greenpepper = new ArrayList<>();
        greenpepper.add("なすと豚肉のピリ辛炒め\n"+ "材料:なす、豚肉、しょうが、ネギ、ピーマン、ごま油\n"+ "1:なすは縦半分に切り、１ｃｍ幅の斜め薄切りにし、水にさらす。\n"+"2:豚肉はひと口大に切り、（Ａ）で下味をつける。\n"+ "3:しょうがは薄切り、ねぎは１ｃｍ幅の斜め輪切りにする。ピーマンはへたと種を取り、細切りにする。にんにくの芽は、４～５ｃｍに切る。\n"+"4:揚げ油を熱し、なすの水気をふいて入れ、さっと揚げ、ペーパータオルなどで油気をしっかり取る。同じようににんにくの芽も揚げる。\n"+"5:(Ｂ）を混ぜ、合わせ調味料をつくっておく。\n"+"6:フライパンにごま油を熱し、ねぎとしょうがを炒め、豚肉を入れる。色が変わったら、なす、ピーマン、にんにくの芽を加えてさっと炒め、（５）をまわしかけて大きく混ぜ、さっと炒める。");

        ArrayList<String> 

        // データベースに食材と対応するレシピを追加
        recipes.put("apple", appleRecipes);
        recipes.put("banana", bananaRecipes);
        recipes.put("chicken", chickenRecipes);
        recipes.put("greenpepper",greenpepper);

        // フレームの作成
        JFrame frame = new JFrame("レシピ検索フォーム");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        
        // レイアウトの設定
        frame.setLayout(new BorderLayout());

        // パネルの作成
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // ラベル、テキストフィールド、ボタンを作成
        JLabel label = new JLabel("食材を入力:");
        JTextField textField = new JTextField(20);
        JButton searchButton = new JButton("レシピ検索");

        // 検索結果を表示するテキストエリア
        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);  // ユーザーが編集できないようにする
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // ボタンのアクションリスナーを追加
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 検索キーワードを取得
                String ingredient = textField.getText().trim().toLowerCase();
                
                // 結果表示エリアをクリア
                resultArea.setText("");

                // レシピがデータベースに存在するか確認
                if (recipes.containsKey(ingredient)) {
                    ArrayList<String> recipeList = recipes.get(ingredient);
                    resultArea.append("「" + ingredient + "」を使ったレシピ:\n");
                    for (String recipe : recipeList) {
                        resultArea.append(recipe + "\n\n");
                    }
                } else {
                    resultArea.setText("「" + ingredient + "」を使ったレシピは見つかりませんでした。");
                }
            }
        });

        // パネルにコンポーネントを追加
        panel.add(label);
        panel.add(textField);
        panel.add(searchButton);

        // フレームにパネルと結果エリアを追加
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // フレームを表示
        frame.setVisible(true);
    }
}