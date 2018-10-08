package com.mahout.start;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * AUTO-GENERATED: houlu @ 2018/9/30 下午4:21
 *
 * @author houlu
 * @version 1.0.0
 * @since 1.0.0
 */
public class ItemSim {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 100;

    public static void main(String[] args) throws IOException, TasteException {
        String file = "datafile/item_sim.csv";
        DataModel scoreDataModel = new FileDataModel(new File(file));


        DataModel model = scoreDataModel;

//        ItemSimilarity item = new LogLikelihoodSimilarity(model);
        ItemSimilarity item = new EuclideanDistanceSimilarity(model);


        double[] value = item.itemSimilarities(101,new long[]{102,103});
        System.out.println("value : " + Arrays.toString(value));

    }

}
