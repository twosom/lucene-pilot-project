package com.lucene.lucenepilotproject.helper;

import com.lucene.lucenepilotproject.model.RestaurantInfoModel;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RestaurantInfoCsvLoader {

    /**
     * resources 폴더 안에 있는 csv 파일을 {@link  RestaurantInfoModel}로 변환합니다.<br/>
     *
     * @return 변환 된 모델 리스트
     */
    public List<RestaurantInfoModel> loadRestaurantInfo() throws IOException {
        String filePath = new ClassPathResource("The_whole_country_restaurant_Info.csv")
                .getFile()
                .getAbsolutePath();

        List<RestaurantInfoModel> restaurantInfoList = null;
        try (Reader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            var csvToBean = new CsvToBeanBuilder<RestaurantInfoModel>(bufferedReader)
                    .withType(RestaurantInfoModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            restaurantInfoList = csvToBean.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantInfoList;
    }
}
