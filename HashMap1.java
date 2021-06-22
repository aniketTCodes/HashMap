import java.util.ArrayList;
import java.util.Set;

class HashMap<K,V> {

    private ArrayList<Node<K,V>> bucketArray=new ArrayList<>();
    private int size;
    private int numBucket;

    public HashMap(){
        size=0;
        numBucket=20;
        for(int i=0;i<numBucket;i++)
        bucketArray.add(null);
    }


    private int hashfunction(K key){
        int hascode=key.hashCode();
        return hascode%numBucket;
    
    }

    public int size(){
        return this.size;
    }

    public V get(K key){
        int bucketidx=hashfunction(key);
        Node<K,V> head=bucketArray.get(bucketidx);
        while(head!=null){
            if(head.key.equals(key))
            return head.value;
            head=head.next;
        }
        return null;
    }

    public V remove(K key){
        V val;
        int idx=hashfunction(key);
        Node<K,V> head=bucketArray.get(idx),prev=null;
        while(head!=null){
            if(head.key.equals(key))
            break;
            prev=head;
            head=head.next;
        }
        if(head==null)
        return null;

        if(prev==null){
        val=head.value;
        bucketArray.set(idx, head.next);
        return val;
        }

        val=head.value;
        prev.next=head.next;
        return val;
        
        
    }

    public void put(K key, V value){
        
        int idx=hashfunction(key);
        Node<K,V> head=bucketArray.get(idx);
        while(head!=null){
            if(head.key.equals(key)){
            head.value=value;
            return;
            }
            head=head.next;
        }
        Node<K,V> newEntry=new Node<K,V>(key,value);
        size++;
        newEntry.next=bucketArray.get(idx);
        bucketArray.set(idx, newEntry);
        double loadFactore=(1.0*size)/numBucket;
        if(loadFactore>0.7)
        rehash();



    }

    private void rehash(){
        ArrayList<Node<K,V>> newBucketArray=bucketArray;
        bucketArray=new ArrayList<>();
        for(int i=0;i<2*numBucket;i++){
            bucketArray.add(null);
        }

        numBucket*=2;
        size=0;
        for(int i=0;i<newBucketArray.size();i++){
            Node<K,V> head=newBucketArray.get(i);
            while(head!=null){
                K key=head.key;
                V val=head.value;
                put(key,val);

            }
        }
        
    }


    public Set<Integer> keySet() {
        return null;
    }


    public boolean containsKey(int consecutive) {
        return false;
    }


    public int getOrDefault(int i2, int i) {
        return 0;
    }
    
}
