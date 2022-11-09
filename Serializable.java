public interface Serializable<T> {
    public String serialize(T object);
    public void deserialize(String str, T object);
}
