package utilities.dataprovider;

import org.testng.annotations.DataProvider;

public class ContractData {
    @DataProvider(name = "contractData")
    public Object[][] contractData() {
        return new Object[][]{
                {"7344498", "21.04.2017", "ЄТехПД Региональної филии ПЗЗ", "110436.14", "UAH", "1", "2", "12.00", "0"},
                {"18-016\\АН", "26.02.2018", "ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ \"ПРОЕКТНА КОМПАНІЯ \"АРКОН\"", "9234.00", "UAH", "2", "1", "122.00", "1"},
                {"964", "02.01.2018", "rrrrrr", "113.00", "USD", "0", "0", "0.00", "0"}
        };
    }
}
