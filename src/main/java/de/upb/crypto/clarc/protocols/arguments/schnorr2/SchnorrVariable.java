package de.upb.crypto.clarc.protocols.arguments.schnorr2;

import de.upb.crypto.math.expressions.VariableExpression;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.annotations.v2.RepresentationRestorer;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * A variable in the context of SchnorrFragments.
 *
 * This is only the (static) variable. SchnorrVariableValue represents a concrete value.
 *
 * Variables are named only for debuggability.
 * Two variables are equal iff they are the same object.
 */
public abstract class SchnorrVariable implements RepresentationRestorer, VariableExpression {
    protected final String name;

    public SchnorrVariable(String name) {
        this.name = name;
    }

    public abstract SchnorrVariableValue generateRandomValue();
    public abstract SchnorrVariableValue recreateValue(Representation repr);

    @Override
    public Object recreateFromRepresentation(Type type, Representation repr) {
        if (!(type instanceof Class))
            throw new IllegalArgumentException("Cannot recreate "+type.getTypeName());

        if (SchnorrVariableValue.class.isAssignableFrom((Class) type))
            return recreateValue(repr);

        throw new IllegalArgumentException("Cannot recreate "+type.getTypeName());
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
