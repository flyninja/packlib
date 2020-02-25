package com.togacure.packlib.impl;

import com.togacure.packlib.interfaces.IPackageValidator;
import com.togacure.packlib.model.Box;
import com.togacure.packlib.model.Package;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author Vitaly Alekseev
 * @since 2/25/2020
 */
@RunWith(SpringRunner.class)
@ComponentScan(basePackageClasses = { PackageValidator.class })
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { PackageValidatorTest.class })
public class PackageValidatorTest {

    @Autowired
    private IPackageValidator packageValidator;


    @Test
    public void allLessThanSuccessTest() {

        val pack = Package.builder().height(1).width(1).depth(1).build();
        val box = Box.builder().height(2).width(2).depth(2).border(0.5f).build();

        Assert.assertTrue(packageValidator.isPackageFitInBox(pack, box));
    }

    @Test
    public void allEqualsSuccessTest() {
        val pack = Package.builder().height(1.5f).width(1.5f).depth(1.5f).build();
        val box = Box.builder().height(2).width(2).depth(2).border(0.5f).build();

        Assert.assertTrue(packageValidator.isPackageFitInBox(pack, box));
    }

    @Test
    public void heightGreatThanFaultTest() {
        val pack = Package.builder().height(2).width(1).depth(1).build();
        val box = Box.builder().height(2).width(2).depth(2).border(0.5f).build();

        Assert.assertFalse(packageValidator.isPackageFitInBox(pack, box));
    }

    @Test
    public void widthGreatThanFaultTest() {
        val pack = Package.builder().height(1).width(2).depth(1).build();
        val box = Box.builder().height(2).width(2).depth(2).border(0.5f).build();

        Assert.assertFalse(packageValidator.isPackageFitInBox(pack, box));
    }

    @Test
    public void depthGreatThanFaultTest() {
        val pack = Package.builder().height(1).width(1).depth(2).build();
        val box = Box.builder().height(2).width(2).depth(2).border(0.5f).build();

        Assert.assertFalse(packageValidator.isPackageFitInBox(pack, box));
    }
}
