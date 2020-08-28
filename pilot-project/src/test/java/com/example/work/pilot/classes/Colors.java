package com.example.work.pilot.classes;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Colors extends ForwardingSet<ColorInformation> {

    private Set<ColorInformation> delegate;

    @Override
    protected Set<ColorInformation> delegate() {
        return delegate();
    }

    public Colors(Colors colors){
        this.delegate = new HashSet<ColorInformation>(colors.delegate);
    }
}
