import com.justin.reader.CSVReader;
import com.justin.model.PropertyInfo;
import org.hamcrest.core.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CSVReaderTest {

    CSVReader obj;

    @Before
    public void setup(){
        try {
            obj = new CSVReader("property-data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadingDocumemt(){
        Assert.assertNotNull(obj);
        Assert.assertNotNull(obj.getPropertyInfoList());
    }

    @Test
    public void testAvgValue(){
        Assert.assertNotNull(obj);
        Assert.assertNotNull(obj.getPropertyInfoList());
        double meanPrice = obj.meanPriceForOnwardPostcode();
        Assert.assertEquals(1158750.0,meanPrice,0);

    }

    @Test
    public void testDiffInDetachedAndFlats(){
        Assert.assertNotNull(obj);
        Assert.assertNotNull(obj.getPropertyInfoList());
        double diff = obj.differenaceInAvgPricesOfDetachedAndFlats();
        Assert.assertEquals(43420.625,diff,0);
    }

    @Test
    public void testTop10ExpensiveProperties(){
        Assert.assertNotNull(obj);
        Assert.assertNotNull(obj.getPropertyInfoList());
        List<PropertyInfo> propertyInfos = obj.findTopExpensiveProperties();
        Assert.assertNotNull(propertyInfos);
        Assert.assertEquals(2,propertyInfos.size());
        Assert.assertThat(propertyInfos.get(0), new IsInstanceOf(PropertyInfo.class));
        Assert.assertEquals("Brighton Road",propertyInfos.get(0).getAddress().trim());
        Assert.assertEquals("GU13 4DD",propertyInfos.get(0).getPostcode());
        Assert.assertThat(propertyInfos.get(1), new IsInstanceOf(PropertyInfo.class));
        Assert.assertEquals("Station Road",propertyInfos.get(1).getAddress().trim());
        Assert.assertEquals("W1F 3UT",propertyInfos.get(1).getPostcode());
    }

}
