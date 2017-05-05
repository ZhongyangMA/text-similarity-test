package com.mzy;

import org.apdplat.word.analysis.CosineTextSimilarity;
import org.apdplat.word.analysis.TextSimilarity;

/**
 * Created by ZhongyangMA on 5/5/17.
 */
public class SimpleTest {

    public static void run() {

        String original = "我爱购物";
        String[] candidates = new String[5];
        candidates[0] = "我爱读书";
        candidates[1] = "我爱读书分割";
        candidates[2] = "我爱读书分割环境";
        candidates[3] = "我爱读书分割环境如果";
        candidates[4] = "我爱读书分割环境如果算法";

        TextSimilarity textSimilarity = new CosineTextSimilarity();

        double[] scores = new double[5];
        for(int i=0; i < candidates.length; i++) {
            scores[i] = textSimilarity.similarScore(original, candidates[i]);
        }

        for(int i=0; i < scores.length; i++) {
            System.out.println(original + " - " + candidates[i] +"：" + scores[i]);
        }

    }

}
