// Generated by delombok at Sun Feb 26 12:31:38 KST 2017
package scouter.bytebuddy.implementation.bytecode.constant;

import scouter.bytebuddy.description.field.FieldDescription;
import scouter.bytebuddy.description.method.MethodDescription;
import scouter.bytebuddy.description.type.TypeDescription;
import scouter.bytebuddy.implementation.Implementation;
import scouter.bytebuddy.implementation.bytecode.StackManipulation;
import scouter.bytebuddy.implementation.bytecode.member.FieldAccess;
import scouter.bytebuddy.implementation.bytecode.member.MethodInvocation;
import scouter.bytebuddy.jar.asm.MethodVisitor;

import java.lang.reflect.Field;

/**
 * Represents a {@link Field} constant for a given type.
 */
public class FieldConstant implements StackManipulation {
    /**
     * The field to be represent as a {@link Field}.
     */
    private final FieldDescription.InDefinedShape fieldDescription;

    /**
     * Creates a new field constant.
     *
     * @param fieldDescription The field to be represent as a {@link Field}.
     */
    public FieldConstant(FieldDescription.InDefinedShape fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    /**
     * Retruns a cached version of this field constant.
     *
     * @return A cached version of this field constant.
     */
    public StackManipulation cached() {
        return new Cached(this);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        try {
            return new Compound(ClassConstant.of(fieldDescription.getDeclaringType()), new TextConstant(fieldDescription.getInternalName()), MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredField", String.class)))).apply(methodVisitor, implementationContext);
        } catch (NoSuchMethodException exception) {
            throw new IllegalStateException("Cannot locate Class::getDeclaredField", exception);
        }
    }


    /**
     * A cached version of a {@link FieldConstant}.
     */
    protected static class Cached implements StackManipulation {
        /**
         * The field constant stack manipulation.
         */
        private final StackManipulation fieldConstant;

        /**
         * Creates a new cached version of a field constant.
         *
         * @param fieldConstant The field constant stack manipulation.
         */
        public Cached(StackManipulation fieldConstant) {
            this.fieldConstant = fieldConstant;
        }

        @Override
        public boolean isValid() {
            return fieldConstant.isValid();
        }

        @Override
        public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            return FieldAccess.forField(implementationContext.cache(fieldConstant, new TypeDescription.ForLoadedType(Field.class))).read().apply(methodVisitor, implementationContext);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public boolean equals(final java.lang.Object o) {
            if (o == this) return true;
            if (!(o instanceof FieldConstant.Cached)) return false;
            final FieldConstant.Cached other = (FieldConstant.Cached) o;
            if (!other.canEqual((java.lang.Object) this)) return false;
            final java.lang.Object this$fieldConstant = this.fieldConstant;
            final java.lang.Object other$fieldConstant = other.fieldConstant;
            if (this$fieldConstant == null ? other$fieldConstant != null : !this$fieldConstant.equals(other$fieldConstant)) return false;
            return true;
        }

        @java.lang.SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        protected boolean canEqual(final java.lang.Object other) {
            return other instanceof FieldConstant.Cached;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final java.lang.Object $fieldConstant = this.fieldConstant;
            result = result * PRIME + ($fieldConstant == null ? 43 : $fieldConstant.hashCode());
            return result;
        }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof FieldConstant)) return false;
        final FieldConstant other = (FieldConstant) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$fieldDescription = this.fieldDescription;
        final java.lang.Object other$fieldDescription = other.fieldDescription;
        if (this$fieldDescription == null ? other$fieldDescription != null : !this$fieldDescription.equals(other$fieldDescription)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof FieldConstant;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $fieldDescription = this.fieldDescription;
        result = result * PRIME + ($fieldDescription == null ? 43 : $fieldDescription.hashCode());
        return result;
    }
}
