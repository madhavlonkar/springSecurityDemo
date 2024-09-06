package com.revshop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleRedirectController {

    @GetMapping("/role-redirect")
    public String redirectBasedOnRole(Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        if (role.equals("ROLE_BUYER")) {
            return "redirect:/buyer-dashboard";
        } else if (role.equals("ROLE_SELLER")) {
            return "redirect:/seller-dashboard";
        }
        return "redirect:/home";  // Default fallback
    }

    @GetMapping("/buyer-dashboard")
    public String buyerDashboard(Model model, Authentication authentication) {
        model.addAttribute("role", "Buyer");
        return "buyer-dashboard";
    }

    @GetMapping("/seller-dashboard")
    public String sellerDashboard(Model model, Authentication authentication) {
        model.addAttribute("role", "Seller");
        return "seller-dashboard";
    }
}
