package io.jenkins.plugins.analysis.warnings;

import org.kohsuke.stapler.DataBoundConstructor;
import org.jenkinsci.Symbol;
import hudson.Extension;

import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider;

/**
 * Provides a parser and customized messages for Simian duplication scanner.
 *
 * @author Ullrich Hafner
 */
public class Simian extends DuplicateCodeScanner {
    private static final long serialVersionUID = 5817021796077055763L;
    private static final String ID = "simian";

    /** Creates a new instance of {@link Simian}. */
    @DataBoundConstructor
    public Simian() {
        super();
        // empty constructor required for stapler
    }

    /** Provides the labels for the static analysis tool. */
    private static class LabelProvider extends DryLabelProvider {
        LabelProvider(final String displayName) {
            super(ID, displayName);
        }
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("simian")
    @Extension
    public static class Descriptor extends DuplicateCodeDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Override
        public boolean canScanConsoleLog() {
            return false;
        }

        @Override
        public StaticAnalysisLabelProvider getLabelProvider() {
            return new LabelProvider(getDisplayName());
        }
    }
}
