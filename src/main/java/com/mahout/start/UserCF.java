package com.mahout.start;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * AUTO-GENERATED: houlu @ 2018/9/30 下午4:21
 *
 * @author houlu
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserCF {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 100;

    public static void main(String[] args) throws IOException, TasteException {
        String file = "datafile/user_cf.csv";
        DataModel scoreDataModel = new FileDataModel(new File(file));
        DataModel clickDataModel = new GenericBooleanPrefDataModel(GenericBooleanPrefDataModel
                .toDataMap(scoreDataModel));

        DataModel model = scoreDataModel;

        UserSimilarity user = new LogLikelihoodSimilarity(model);
//        UserSimilarity user = new UncenteredCosineSimilarity(model);

        System.out.println("sim 1-->2 : " + user.userSimilarity(1, 2));
        System.out.println("sim 2-->3 : " + user.userSimilarity(2, 3));

        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user,
                model);
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);

        LongPrimitiveIterator iter = model.getUserIDs();

        while (iter.hasNext()) {
            long uid = iter.nextLong();
            List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
            System.out.printf("uid:%s", uid);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
            }
            System.out.println();
        }
    }

}
