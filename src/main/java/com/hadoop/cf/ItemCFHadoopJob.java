package com.hadoop.cf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobConf;
import org.apache.mahout.cf.taste.hadoop.item.RecommenderJob;
import org.apache.mahout.cf.taste.hadoop.similarity.item.ItemSimilarityJob;

public class ItemCFHadoopJob {

    private static final String HDFS = "hdfs://192.168.1.210:9000";

    public static void main(String[] args) throws Exception {
//        String localFile = "datafile/item.csv";
//        String inPath = HDFS + "/user/hdfs/userCF";
//        String inFile = inPath + "/item.csv";
//        String outPath = HDFS + "/user/hdfs/userCF/result/";
//        String outFile = outPath + "/part-r-00000";
//        String tmpPath = HDFS + "/tmp/" + System.currentTimeMillis();
//
//        JobConf conf = config();
//        HdfsDAO hdfs = new HdfsDAO(HDFS, conf);
//        hdfs.rmr(inPath);
//        hdfs.mkdirs(inPath);
//        hdfs.copyFile(localFile, inPath);
//        hdfs.ls(inPath);
//        hdfs.cat(inFile);
        Configuration conf = new Configuration();

        StringBuilder sb = new StringBuilder();
        sb.append("--input ").append("/apps/GitWorkSpace/mahout_demo/datafile/source/item_cf_1.csv");
        sb.append(" --output ")
                .append("/apps/GitWorkSpace/mahout_demo/datafile/mr_result/recommend_result");
        sb.append(" --booleanData false");
        sb.append(
                " --similarityClassname org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.CooccurrenceCountSimilarity");
        sb.append(" --tempDir ").append("/apps/GitWorkSpace/mahout_demo/datafile/temp");
        args = sb.toString().split(" ");

        RecommenderJob job = new RecommenderJob();
        job.setConf(conf);
        job.run(args);
//        hdfs.cat(outFile);
    }

}
