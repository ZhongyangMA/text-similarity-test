package com.mzy;

import org.apdplat.word.analysis.CosineTextSimilarity;
import org.apdplat.word.analysis.TextSimilarity;
import org.apdplat.word.segmentation.SegmentationAlgorithm;

/**
 * Created by ZhongyangMA on 5/5/17.
 */
public class SimpleTest {

    public static void run() {

        String original = "奥迪A6L 2014款 35 FSI 舒适型";
        String[] candidates = new String[5];
        candidates[0] = "2009款 A6L 2.8FSI 无级 舒适娱乐型";
        candidates[1] = "2014款 A6L 2.0TFSI 无级 舒适型";
        candidates[2] = "2014款 A6L 2.8FSI 双离合 35FSI quattro豪华型";
        candidates[3] = "2014款 A6L 2.8FSI 无级 35FSI 豪华型";
        candidates[4] = "2014款 A6L 2.8FSI 无级 35FSI 舒适型";

        TextSimilarity textSimilarity = new CosineTextSimilarity();
        textSimilarity.setSegmentationAlgorithm(SegmentationAlgorithm.BidirectionalMaximumMinimumMatching);

        double[] scores = new double[5];
        for(int i=0; i < candidates.length; i++) {
            scores[i] = textSimilarity.similarScore(original, candidates[i]);
        }

        for(int i=0; i < scores.length; i++) {
            System.out.println("[" + original + "] - [" + candidates[i] + "] 余弦相似度：" + scores[i]);
        }

    }

}
