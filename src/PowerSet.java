package src;

public class PowerSet
{
    private final int DEFAULT_SIZE = 20000;

    public int ss;
    private int size;

    private String[] slots;
    private int step = 3;



    public PowerSet()
    {
        ss = DEFAULT_SIZE;
        slots = new String[ss];
        size = 0;
        for (int i = 0; i < ss; i++) slots[i] = null;

    }

    public PowerSet(int sizeOf)
    {
        ss = sizeOf;
        slots = new String[ss];
        size = 0;
        for (int i = 0; i < ss; i++) slots[i] = null;

    }

    public int size()
    {
        return size;
    }

    public String[] getContents() {
        String[] res = new String[size];
        int j = 0;

        for (int i = 0; i < ss; i++) {
            if (slots[i] != null) {
                res[j] = slots[i];
                j++;
            }
        }
        return res;
    }


    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++){
            sum += value.charAt(i);
        }
        return (sum % ss);
    }

    public int seekSlot(String value)
    {
        int i;
        i = hashFun(value);
        i = checkIndex(i, value);
        return i;
    }

    public int checkIndex(int i, String key) {
        i = checkViaStep(i, key);
        if (i >= ss) i = checkEach(key);
        if (i >= ss) i = -1;
        return i;
    }

    public int checkViaStep(int i, String key) {
        for(;i < ss && slots[i] != null; i+=step){
            if(slots[i%ss].equals(key)) break;
        }
        return i;
    }

    public int checkEach(String key) {
        int i = 0;
        for(; i < ss && slots[i] != null; i++){
            if(slots[i%ss].equals(key)) break;
        }
        return i;
    }


    public void put(String value)
    {
        if (this.get(value)) return;

        int i;
        i = seekSlot(value);
        if(i != -1) {
            slots[i] = value;
            size++;
        }
    }

    public boolean get(String value)
    {
        int i = hashFun(value);
        if(value.equals(slots[i])) return true;

        for (i = 0; i < ss; i++)
            if(value.equals(slots[i])) return true;

        return false;
    }

    public boolean remove(String value)
    {
        int i = hashFun(value);
        if(value.equals(slots[i])) {
            slots[i] = null;
            size--;
            return true;
        }

        for (i = 0; i < ss; i++)
            if(value.equals(slots[i])) {
                slots[i] = null;
                size--;
                return true;
            }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        String[] sStr = this.getContents();

        for (int i = 0; i < size; i++) {
            if (set2.get(sStr[i])) res.put(sStr[i]);
        }

        return res;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        String[] s1str = this.getContents();
        String[] s2str = set2.getContents();

        for (int i = 0; i < size; i++) res.put(s1str[i]);
        for (int i = 0; i < s2str.length; i++) res.put(s2str[i]);

        return res;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        String[] sStr = this.getContents();

        for (int i = 0; i < sStr.length; i++) {
            if (!(set2.get(sStr[i]))) res.put(sStr[i]);
        }

        return res;
    }

    public boolean isSubset(PowerSet set2)
    {
        String[] s2 = set2.getContents();

        for (int i = 0; i < set2.size(); i++) {
            if (!this.get(s2[i])) return false;
        }
        return true;
    }

}