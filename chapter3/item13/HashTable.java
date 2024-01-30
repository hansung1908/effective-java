package chapter3.item13;

// 코드 13-4 복잡한 가변 상태를 갖는 클래스용 재귀적 clone 메서드
public class HashTable implements Cloneable{
    private Entry[] buckets = new Entry[50];
    private int size = 0;

    public void put(Entry entry){
        buckets[size++] = entry;
    }

    public void printAll(){
        for (int i=0;i<size;i++){
            System.out.println(buckets[i].toString());
        }
    }

    static class Entry{
        final Object key;
        Object value;
        Entry next;

        public Entry(final Object key, final Object value, final Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

//        // 이 엔트리가 가리키는 연결 리스트를 재귀적으로 복사
//        // 하지만 재귀 호출 때문에 리스트의 원소 수만큼 스택 프레임을 소비하여, 리스트가 길면 스택 오버플로를 일으킬 위험이 있다.
//        Entry deepCopy(){
//            return new Entry(key,value, next==null ? null : next.deepCopy());
//        }

        // 코드 13-5 엔트리 자신이 가리키는 연결 리스트를 반복적으로 복사한다.
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);

            // 재귀 호출 대신 반복자를 써서 순회하는 방향으로 수정해야 한다.
            for(Entry p = result; p.next != null; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);

            return result;
        }
    }

//    // 코드 13-3 잘못된 clone 메서드 - 가변 상태를 공유한다! (얕은 복사)
//    @Override public HashTable clone() {
//        try {
//            HashTable result = (HashTable) super.clone();
//            result.buckets = buckets.clone();
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    // 먼저 적절한 크기의 새로운 버킷 배열을 할당한 다음 원래 버킷 배열을 순회하며 비지 않은 각 버킷에 대해 깊은 복사를 수행한다.
    // 이때 Entry의 deepCopy 메서드는 자신이 가리키는 연결 리스트 전체를 복사하기 위해 자신을 재귀적으로 호출한다.
    @Override public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];

            for (int i =0; i < buckets.length; i++){
                if(buckets[i] != null){
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }

            return result;
        }catch (CloneNotSupportedException cloneNotSupportedException){
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable1 = new HashTable();
        hashTable1.put(new HashTable.Entry("person1", 10, null));

        HashTable.Entry entry1 = new HashTable.Entry("person2", 20, null);
        HashTable.Entry entry2 = new HashTable.Entry("person3", 30, entry1);
        hashTable1.put(entry2);

        HashTable hashTable2 = hashTable1.clone();

        System.out.println("----------------hashTable1----------------");
        hashTable1.printAll();

        System.out.println("----------------hashTable2----------------");
        hashTable2.printAll();
    }
}
