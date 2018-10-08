package com.hadoop.cf;

import org.apache.hadoop.conf.Configuration;
import org.apache.mahout.cf.taste.hadoop.similarity.item.ItemSimilarityJob;

/**
 * AUTO-GENERATED: houlu @ 2018/10/3 下午3:55
 *
 * @author houlu
 * @version 1.0.0
 * @since 1.0.0
 */
public class ItemSimJob {

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        StringBuilder sb = new StringBuilder();
        sb.append("--input ").append("/apps/GitWorkSpace/mahout_demo/datafile/source");
        sb.append(" --output ").append("/apps/GitWorkSpace/mahout_demo/datafile/mr_result/sim_result");
        sb.append(
                " --similarityClassname org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.CooccurrenceCountSimilarity");
        sb.append(" --tempDir ").append("/apps/GitWorkSpace/mahout_demo/datafile/temp");
        args = sb.toString().split(" ");

        ItemSimilarityJob job = new ItemSimilarityJob();



        job.setConf(conf);
        job.run(args);
    }
}
