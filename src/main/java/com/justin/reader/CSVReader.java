package com.justin.reader;

import com.justin.model.PropertyInfo;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {

    private List<PropertyInfo> propertyInfoList;

    public CSVReader(String filPath) throws IOException {
        readFile(filPath);
    }

    private void readFile(String filePath) throws IOException{
        File file = new File(filePath);
        try (InputStream inputFileStream = new FileInputStream(file)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFileStream));
            propertyInfoList = bufferedReader.lines() //get lines are stream
                    .skip(1) // skip the header line
                    .map(s-> mapLineToPropertyInfo(s)) // map the line to PropertyInfo object
                    .collect(Collectors.toList()); // return as list of PropertyInfo objects
        }
    }

    private  PropertyInfo mapLineToPropertyInfo(String line) {
        String[] properties = line.split(",");
        PropertyInfo returnObj = new PropertyInfo();
        returnObj.setPropertyReference(StringUtils.isNotBlank(properties[0]) ?Integer.parseInt(properties[0]) : 0);
        returnObj.setPrice(StringUtils.isNotBlank(properties[1]) ?Integer.parseInt(properties[1]) : 0);
        returnObj.setNoOfBedrooms(StringUtils.isNotBlank(properties[2]) ?Integer.parseInt(properties[2]) : 0);
        returnObj.setNoOfBathrooms(StringUtils.isNotBlank(properties[3]) ?Integer.parseInt(properties[3]) : 0);
        returnObj.setHouseNumber(properties[4]);
        returnObj.setAddress(properties[5]);
        returnObj.setRegion(properties[6]);
        returnObj.setPostcode(properties[7]);
        returnObj.setPropertyType(properties[8]);
        return returnObj;
    }

    public double meanPriceForOnwardPostcode(){
        if(propertyInfoList!=null && !propertyInfoList.isEmpty()){
            return propertyInfoList.stream().filter(x->x.getPostcode().startsWith("W1F"))
                    .mapToInt(PropertyInfo::getPrice).average().getAsDouble();
        }
        return 0;
    }

    public double differenaceInAvgPricesOfDetachedAndFlats(){
        if(propertyInfoList!=null && !propertyInfoList.isEmpty()){
            double avgPriceForDetachedHouse = propertyInfoList.stream()
                    .filter(x->"Detached".equals(x.getPropertyType()))
                    .mapToInt(PropertyInfo::getPrice).average().getAsDouble();
            double avgPriceForFlat = propertyInfoList.stream()
                    .filter(x->"Flat".equals(x.getPropertyType()))
                    .mapToInt(PropertyInfo::getPrice).average().getAsDouble();
            return Math.abs(avgPriceForDetachedHouse-avgPriceForFlat);
        }
        return 0;
    }

    public List<PropertyInfo> findTopExpensiveProperties(){
        if(propertyInfoList!=null && !propertyInfoList.isEmpty()){
            Collections.sort(propertyInfoList, new Comparator<PropertyInfo>() {
                @Override
                public int compare(PropertyInfo o1, PropertyInfo o2) {
                    return o2.getPrice().compareTo(o1.getPrice());
                }
            });
            int count = propertyInfoList.size()/10;
            return propertyInfoList.stream()
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<PropertyInfo> getPropertyInfoList(){
        return propertyInfoList;
    }
}
