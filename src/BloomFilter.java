package src;

public class BloomFilter extends BloomFilterAbs
{
    public final int PUT_STATUS_NIL= 0; // put method hadn't been evoked yet
    public final int PUT_STATUS_OK = 1; // put method run correctly
    public final int PUT_STATUS_ERR = 2; // put method run with error

    public final int CHECK_ELEMENT_STATUS_NIL= 0; // checkElement worked correctly
    public final int CHECK_ELEMENT_STATUS_OK = 1; // checkElement worked with error

    private static final int RAND1 = 17;
    private static final int RAND2 = 223;
    int MASK = 0x0_000_0000;

    int check;
    int binaryString;

    int putStatus = PUT_STATUS_NIL;
    int checkElementStatus = CHECK_ELEMENT_STATUS_NIL;

    int filter_len;

    public BloomFilter(int f_len)
    {
        super(f_len);
        filter_len = f_len;
        binaryString = MASK;

    }

    public int hash1(String str1)
    {
        return hF(str1, RAND1);
    }

    public int hash2(String str1)
    {
        return hF(str1, RAND2);
    }

    @Override
    public void put(String str1)
    {
        binaryString = hash1(str1) | binaryString;
        binaryString = hash2(str1) | binaryString;

        putStatus = PUT_STATUS_OK;
    }

    public boolean checkElement(String str1)
    {
        int i1 = hash1(str1);
        int i2 = hash2(str1);

        checkElementStatus = CHECK_ELEMENT_STATUS_OK;

        return ((binaryString & i1) == i1) && ((binaryString & i2) == i2) ;
    }


    private int hF(String str, int rand) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = (sum*rand + str.charAt(i)) % filter_len;
        }

        return sum | MASK;
    }

    @Override
    public int get_put_status() {
        return putStatus;
    }

    @Override
    public int get_checkElement_status() {
        return checkElementStatus;
    }


}