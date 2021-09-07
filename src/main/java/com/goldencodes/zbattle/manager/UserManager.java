package com.goldencodes.zbattle.manager;

import com.goldencodes.zbattle.manager.phase.util.User;

import java.util.*;

public class UserManager {

    private Map<UUID, User> users = new HashMap<UUID, User>();
    private ArrayList<UUID> hosts = new ArrayList<UUID>();

    public void setHost(UUID uniqueId) {
        hosts.add(uniqueId);
    }

    public void removeHost(UUID uniqueIUd) {
        hosts.remove(uniqueIUd);
    }

    public boolean isHost(UUID uniqueId) {
        return true;
    }

    public int getPlayers() {
        return -1;
    }

    public User get(UUID uuid) {
        return users.get(uuid);
    }

    public boolean has(UUID uuid) {
        return users.containsKey(uuid);
    }

    public void add(User user) {
        users.put(user.getCoreUser().getUUID(), user);
    }

    public Collection<User> toCollection(){
        return users.values();
    }

    public void remove(UUID uuid){
        users.remove(uuid);
    }
}
