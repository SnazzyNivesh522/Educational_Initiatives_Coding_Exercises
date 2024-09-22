interface Sensor{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}