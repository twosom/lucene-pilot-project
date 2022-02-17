package com.lucene.lucenepilotproject.service;

import com.lucene.lucenepilotproject.model.RestaurantInfoModel;
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class RestaurantInfoIndexService {

    public void indexRestaurantInfo(List<RestaurantInfoModel> restaurantInfoModels) throws IOException {

        FSDirectory indexDirectory = FSDirectory.open(Paths.get("./index"));

        KoreanAnalyzer koreanAnalyzer = new KoreanAnalyzer();

        IndexWriterConfig config = new IndexWriterConfig(koreanAnalyzer);

        IndexWriter writer = new IndexWriter(indexDirectory, config);

        restaurantInfoModels.forEach(i -> addDocument(i, writer));

        writer.close();
    }

    private void addDocument(RestaurantInfoModel restaurantInfoModel, IndexWriter writer) {


        try {
            Document doc = new Document();
            doc.add(new TextField("restaurantName", restaurantInfoModel.getRestaurantName(), Field.Store.YES));
            doc.add(new StringField("category1", restaurantInfoModel.getCategory1(), Field.Store.YES));
            doc.add(new StringField("category2", restaurantInfoModel.getCategory2(), Field.Store.YES));
            doc.add(new StringField("category3", restaurantInfoModel.getCategory3(), Field.Store.YES));
            doc.add(new StringField("region", restaurantInfoModel.getRegion(), Field.Store.YES));
            doc.add(new StringField("city", restaurantInfoModel.getCity(), Field.Store.YES));
            doc.add(new TextField("description", restaurantInfoModel.getDescription(), Field.Store.YES));
            writer.addDocument(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
